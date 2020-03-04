package com.cinq.cloudstraeamdemo.converter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import com.cinq.cloudstraeamdemo.dto.Property;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ConvertPropertyTest {

  private ConvertProperty fixture;
  private String line = "2013-04-25\tsell\tapartment\tMondubim\t|Brasil|Ceará|Fortaleza|Mondubim|\t\t\t\t\t155900.0\tBRL\t155608.08\t48648.81\t\t\t\t\t\t2\t";
  private String[] fields;

  @Before
  public void setUp() {
    fixture = new ConvertProperty();
    fields = line.split("\t");
  }

  @Test
  public void shouldConvertSingleLine() {
    Property result = fixture.convertTo(fields);
    assertNotNull(result);

    assertEquals("apartment", result.getType());
    assertEquals(155900.0, result.getPrice(), 1.0);
    assertEquals(48648.0, result.getPriceUsd(), 1.0);
    assertEquals(2, result.getRooms());
    assertEquals("Brasil", result.getCountry());
    assertEquals("Fortaleza", result.getCity());
    assertEquals("Ceará", result.getState());
  }

  @Test
  public void shouldIgnoreConvertionForInvalidLines() {
    Property result = fixture.convertTo(new String[0]);
    assertNull(result);
  }

}
