package com.cinq.cloudstreamdemo.provider;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.io.File;
import org.junit.Before;
import org.junit.Test;

public class SearchDataFileOnDiskTest {

  private SearchDataFileOnDisk fixture;

  @Before
  public void setUp() {
    fixture = new SearchDataFileOnDisk("./test-source");
  }

  @Test
  public void shouldRetrieveFirstFile() {
    File result = fixture.searchNextFile();
    assertNotNull(result);
    assertEquals("brazil-cities.zip", result.getName());
  }

  @Test
  public void shouldRetrieveAllFiles() {
    File result = fixture.searchNextFile();
    assertNotNull(result);
    result = fixture.searchNextFile();
    assertNull(result);
  }

}
