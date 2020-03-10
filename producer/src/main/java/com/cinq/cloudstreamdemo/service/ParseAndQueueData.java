package com.cinq.cloudstreamdemo.service;

import com.cinq.cloudstreamdemo.converter.ConvertCity;
import com.cinq.cloudstreamdemo.dto.City;
import com.cinq.cloudstreamdemo.messaging.BrazilCitiesProducerChannel;
import com.cinq.cloudstreamdemo.provider.PreProcessor;
import com.cinq.cloudstreamdemo.provider.SearchDataFileOnDisk;
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
  private final ConvertCity converter;
  private final BrazilCitiesProducerChannel brazilCitiesProducerChannel;

  public ParseAndQueueData(final SearchDataFileOnDisk filesOnDisk, final ConvertCity converter, final BrazilCitiesProducerChannel brazilCitiesProducerChannel) {
    this.filesOnDisk = filesOnDisk;
    this.converter = converter;
    this.brazilCitiesProducerChannel = brazilCitiesProducerChannel;
  }

  public void parseFilesAndProduce() {
    File nextFile;
    while ((nextFile = filesOnDisk.searchNextFile()) != null) {
      try (PreProcessor preProcessor = new PreProcessor(nextFile, true)) {
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

  private void sendData(final City property) {
    boolean sent = brazilCitiesProducerChannel.brazilCitiesProducerChannel().send(MessageBuilder.withPayload(property).build());
    log.debug("Message sent {}", property.getCity());
  }
}
