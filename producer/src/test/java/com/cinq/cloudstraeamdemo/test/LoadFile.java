package com.cinq.cloudstraeamdemo.test;

import static org.junit.Assert.fail;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public interface LoadFile {

  default String loadFileToString(String location) {
    try (InputStream input = this.getClass().getResourceAsStream(location); ByteArrayOutputStream output = new ByteArrayOutputStream()) {
      byte b[] = new byte[1024];
      int i = 0;
      while ((i = input.read(b)) > 0) {
        output.write(b, 0, i);
      }
      output.flush();

      return output.toString();

    } catch (IOException e) {
      fail(String.format("Could not load %s", location));
    }
    return "";
  }

}
