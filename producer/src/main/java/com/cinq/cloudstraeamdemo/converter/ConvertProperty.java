package com.cinq.cloudstraeamdemo.converter;

import com.cinq.cloudstraeamdemo.dto.Property;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ConvertProperty {

  public Property convertTo(final String[] fields) {
    if (fields.length < 24) {
      log.warn("Line ignored, incorrect number of fields");
      return null;
    }

    String[] location = fields[4].split("[|]");

    Property property = new Property();
    property.setCity(location.length>3?location[3]:null);
    property.setState(location.length>2?location[2]:null);
    property.setCountry(location.length>1?location[1]:null);
    property.setCurrency(fields[10]);
    property.setOperation(fields[1]);
    property.setPlaceName(fields[3]);
    property.setPrice(fields[9].isEmpty()?0.0:Double.valueOf(fields[9]));
    property.setPriceUsd(fields[12].isEmpty()?0.0:Double.valueOf(fields[12]));
    property.setRooms(fields[18].isEmpty()?0:Integer.valueOf(fields[18]));
    property.setType(fields[2]);

    return property;
  }
}
