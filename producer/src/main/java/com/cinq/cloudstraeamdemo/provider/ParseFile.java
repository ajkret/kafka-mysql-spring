package com.cinq.cloudstraeamdemo.provider;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.zip.ZipInputStream;
import lombok.extern.slf4j.Slf4j;

/**
 * Parse a CSV file inside a zip file, based on the source from Kaggle (Brazil Real State)
 */
@Slf4j
public class ParseFile implements Closeable {

  private Scanner stream;

  /**
   * Open the zip file
   * @param origin Check SearchDataFileOnDisk
   * @return
   * @throws IOException
   */
  public Scanner open(final File origin) throws IOException {
    ZipInputStream zipFile = new ZipInputStream(new FileInputStream(origin));
    zipFile.getNextEntry();
    this.stream = new Scanner(zipFile);
    return this.stream;
  }

  /**
   * Read next line
   * @return
   */
  public String[] readLine() {
    if(stream.hasNextLine()) {
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
