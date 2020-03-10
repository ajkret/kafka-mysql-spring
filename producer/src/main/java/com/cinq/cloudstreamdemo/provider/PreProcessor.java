package com.cinq.cloudstreamdemo.provider;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.zip.ZipInputStream;
import lombok.extern.slf4j.Slf4j;

/**
 * Parse a CSV file inside a zip file, based on the source from Kaggle (Brazil Real State)
 */
@Slf4j
public class PreProcessor implements Closeable {

  private Scanner stream;
  private boolean firstLine = true;

  /**
   * Open the zip file
   *
   * @param origin Check SearchDataFileOnDisk
   */
  public PreProcessor(final File origin, final boolean ignoreHeader) throws IOException {
    if (origin == null) {
      throw new IOException("Null Source");
    }
    ZipInputStream zipFile = new ZipInputStream(new FileInputStream(origin));
    zipFile.getNextEntry();
    this.stream = new Scanner(zipFile);
    firstLine = ignoreHeader;
  }

  /**
   * Read next line
   */
  public String[] readLine() {
    // Ignore header
    if (firstLine) {
      if (stream.hasNextLine()) {
        stream.nextLine();
      }
      firstLine = false;
    }

    // Consume one line
    if (stream.hasNextLine()) {
      String[] fields = stream.nextLine().split(";");

      // Clean data
      for (int i = 0; i < fields.length; i++) {
        fields[i] = fields[i].replace("\"", "");
      }
      return fields;
    }
    return null;
  }

  @Override
  public void close() throws IOException {
    if (this.stream != null) {
      this.stream.close();
      this.stream = null;
    }
  }
}
