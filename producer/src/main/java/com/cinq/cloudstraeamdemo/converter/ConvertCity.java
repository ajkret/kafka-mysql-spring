package com.cinq.cloudstraeamdemo.converter;

import com.cinq.cloudstraeamdemo.dto.City;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ConvertCity {

  public City convertTo(final String[] fields) {
    if (fields.length < 81) {
      log.warn("Line ignored, incorrect number of fields");
      return null;
    }

    City property = new City();
    property.setCity(fields[0]);
    property.setState(fields[1]);
    property.setResidents(Integer.valueOf(fields[3]));
    property.setForeigners(Integer.valueOf(fields[5]));
    property.setDomesticUnits(Integer.valueOf(fields[6]));
    property.setHdiRanking(Double.valueOf(fields[19]));
    property.setLongitude(Double.valueOf(fields[23]));
    property.setLatitude(Double.valueOf(fields[24]));
    property.setGdp(Double.valueOf(fields[39]));
    property.setPopulation(Integer.valueOf(fields[31]));

    return property;
  }
}
