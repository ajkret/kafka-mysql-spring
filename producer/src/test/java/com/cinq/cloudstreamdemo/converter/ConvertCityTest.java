package com.cinq.cloudstreamdemo.converter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import com.cinq.cloudstreamdemo.dto.City;
import org.junit.Before;
import org.junit.Test;

public class ConvertCityTest {

  private ConvertCity fixture;
  private String[] fields;
  private String line = "Abadia De Goiás;GO;0;6876;6876;0;2137;1546;591;5300;69;318;438;517;3542;416;319;1843;1689;0.708;0.687;0.83;0.622;-49.44054783;-16.75881189;893.6;360;842;147.26;;;8583;Urbano;6.2;27991.25;74750.32;36915.04;145857.6;20554.2;166.41;8053;20664.57;Demais serviÃ§os;28227691;284;5;1;56;0;2;29;110;26;4;5;0;2;10;12;4;6;6;1;5;0;0;;;;;;;;;2158;1246;0;;;;1";

  @Before
  public void setUp() {
    fixture = new ConvertCity();
    fields = line.split(";");
  }

  @Test
  public void shouldConvertSingleLine() {
    City result = fixture.convertTo(fields);
    assertNotNull(result);

    assertEquals("Abadia De Goiás", result.getCity());
    assertEquals("GO", result.getState());
    assertEquals(6876, result.getResidents());

  }

  @Test
  public void shouldIgnoreConvertionForInvalidLines() {
    City result = fixture.convertTo(new String[0]);
    assertNull(result);
  }
}
