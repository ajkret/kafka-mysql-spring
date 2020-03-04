package com.cinq.cloudstraeamdemo.provider;

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

  /**
   * Open the zip file
   *
   * @param origin Check SearchDataFileOnDisk
   */
  public PreProcessor(final File origin) throws IOException {
    if (origin == null) {
      throw new IOException("Null Source");
    }
    ZipInputStream zipFile = new ZipInputStream(new FileInputStream(origin));
    zipFile.getNextEntry();
    this.stream = new Scanner(zipFile);
  }

  /**
   * Read next line
   */
  public String[] readLine() {
    if (stream.hasNextLine()) {
      return stream.nextLine().split(",");
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
