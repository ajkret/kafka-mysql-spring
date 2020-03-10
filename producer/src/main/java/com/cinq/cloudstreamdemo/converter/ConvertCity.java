package com.cinq.cloudstreamdemo.converter;

import com.cinq.cloudstreamdemo.dto.City;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ConvertCity {

  public City convertTo(final String[] fields) {
    City property = new City();
    property.setCity(fields[0]);
    property.setState(fields[1]);
    property.setResidents(fields[3].isEmpty()?0:Integer.valueOf(fields[3]));
    property.setForeigners(fields[5].isEmpty()?0:Integer.valueOf(fields[5]));
    property.setDomesticUnits(fields[6].isEmpty()?0:Integer.valueOf(fields[6]));
    property.setHdiRanking(fields[19].isEmpty()?0.0:Double.valueOf(fields[19]));
    property.setLongitude(fields[23].isEmpty()?0.0:Double.valueOf(fields[23]));
    property.setLatitude(fields[24].isEmpty()?0.0:Double.valueOf(fields[24]));
    property.setGdp(fields[39].isEmpty()?0.0:Double.valueOf(fields[39]));
    property.setPopulation(fields[31].isEmpty()?0:Integer.valueOf(fields[31]));

    return property;
  }
}
