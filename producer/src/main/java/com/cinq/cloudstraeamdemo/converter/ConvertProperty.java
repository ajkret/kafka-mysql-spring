package com.cinq.cloudstraeamdemo.converter;

import com.cinq.cloudstraeamdemo.dto.Property;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ConvertProperty {

  public Property convertTo(final String[] fields) {
    if (fields.length < 19) {
      log.warn("Line ignored, incorrect number of fields");
      return null;
    }

    String[] location = fields[4].split("[|]");

    Property property = new Property();
    property.setCity(location[3]);
    property.setState(location[2]);
    property.setCountry(location[1]);
    property.setCurrency(fields[10]);
    property.setOperation(fields[1]);
    property.setPlaceName(fields[3]);
    property.setPrice(Double.valueOf(fields[9]));
    property.setPriceUsd(Double.valueOf(fields[12]));
    property.setRooms(Integer.valueOf(fields[18]));
    property.setType(fields[2]);

    return property;
  }
}
