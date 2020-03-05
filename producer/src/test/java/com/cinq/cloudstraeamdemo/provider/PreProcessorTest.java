package com.cinq.cloudstraeamdemo.provider;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import org.junit.Before;
import org.junit.Test;

public class PreProcessorTest {

  private File source;

  @Before
  public void setUp() {
    source = new File("./test-source/brazil-cities.zip");
  }

  @Test
  public void shouldProcessZipFileAndConsumeAllLines() {
    try (PreProcessor fixture = new PreProcessor(source, true)) {
      String[] fields;
      while ((fields = fixture.readLine()) != null) {
        assertEquals(81, fields.length);
      }
    } catch (IOException e) {
      fail();
    }
  }

  @Test
  public void shouldFailToProcessZipFileDueToNullFile() {
    try (PreProcessor fixture = new PreProcessor(null, false)) {
      fail();
    } catch (IOException e) {
    }
  }

  @Test
  public void shouldFailToProcessZipFileDueToInvalidFile() {
    try (PreProcessor fixture = new PreProcessor(new File("/tmp/does_not_exist"), false)) {
      fail();
    } catch (IOException e) {
    }
  }

}
