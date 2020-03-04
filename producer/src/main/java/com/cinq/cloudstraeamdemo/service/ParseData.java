package com.cinq.cloudstraeamdemo.service;

import com.cinq.cloudstraeamdemo.converter.ConvertProperty;
import com.cinq.cloudstraeamdemo.dto.Property;
import com.cinq.cloudstraeamdemo.provider.PreProcessor;
import com.cinq.cloudstraeamdemo.provider.SearchDataFileOnDisk;
import java.io.File;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ParseData {

  private final SearchDataFileOnDisk filesOnDisk;
  private final ConvertProperty converter;

  public ParseData(final SearchDataFileOnDisk filesOnDisk, final ConvertProperty converter) {
    this.filesOnDisk = filesOnDisk;
    this.converter = converter;
  }

  public void parseFilesAndProduce() {
    File nextFile;
    while ((nextFile = filesOnDisk.searchNextFile()) != null) {
      try (PreProcessor preProcessor = new PreProcessor(nextFile)) {
        String[] fields = preProcessor.readLine();

        Property property = converter.convertTo(fields);

        // TODO send to kafka

      } catch (IOException e) {
        log.error("Error processing file {}", nextFile);
      }
    }
  }
}
