package com.cinq.cloudstraeamdemo.service;

import com.cinq.cloudstraeamdemo.converter.ConvertProperty;
import com.cinq.cloudstraeamdemo.dto.Property;
import com.cinq.cloudstraeamdemo.messaging.RealEstateProducerChannel;
import com.cinq.cloudstraeamdemo.provider.PreProcessor;
import com.cinq.cloudstraeamdemo.provider.SearchDataFileOnDisk;
import java.io.File;
import java.io.IOException;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ParseAndQueueData {

  private final SearchDataFileOnDisk filesOnDisk;
  private final ConvertProperty converter;
  private final RealEstateProducerChannel realEstateProducerChannel;

  public ParseAndQueueData(final SearchDataFileOnDisk filesOnDisk, final ConvertProperty converter, final RealEstateProducerChannel realEstateProducerChannel) {
    this.filesOnDisk = filesOnDisk;
    this.converter = converter;
    this.realEstateProducerChannel = realEstateProducerChannel;
  }

  public void parseFilesAndProduce() {
    File nextFile;
    while ((nextFile = filesOnDisk.searchNextFile()) != null) {
      try (PreProcessor preProcessor = new PreProcessor(nextFile)) {
        String[] fields;
        while ((fields = preProcessor.readLine()) != null) {
          if (fields[0].startsWith("created_on")) {
            continue;
          }

          Optional.ofNullable(converter.convertTo(fields)).ifPresent(this::sendData);

        }
      } catch (IOException e) {
        log.error("Error processing file {}", nextFile);
      }
    }
  }

  private void sendData(final Property property) {
    boolean sent = realEstateProducerChannel.realEstateProducerChannel().send(MessageBuilder.withPayload(property).build());
    log.debug("Message sent {}", property.getPlaceName());
  }
}
