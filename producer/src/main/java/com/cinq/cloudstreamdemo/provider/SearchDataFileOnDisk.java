package com.cinq.cloudstreamdemo.provider;

import java.io.File;
import java.util.HashSet;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SearchDataFileOnDisk {

  private final String sourceFolder;
  private final Set<String> lastFilesProcessed = new HashSet<>();

  public SearchDataFileOnDisk(@Value("${application.demo.source-folder:./source}")final String sourceFolder) {
    this.sourceFolder = sourceFolder;
  }

  public File searchNextFile() {
    File source = new File(sourceFolder);

    if(!source.isDirectory()) {
      log.warn("Source folder is invalid {}", source.getAbsolutePath());
      return null;
    }

    File[] files = source.listFiles((dir, name) -> name.endsWith(".zip"));
    for(File file : files) {
      if(!lastFilesProcessed.contains(file.getAbsolutePath())) {
        lastFilesProcessed.add(file.getAbsolutePath());
        return file;
      }
    }

    return null;
  }
}
