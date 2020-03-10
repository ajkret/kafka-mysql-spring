package com.cinq.cloudstreamdemo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CityDto {

  private String city;
  private String state;
  private long population;
  private long residents;
  private long foreigners;
  private long domesticUnits;
  private double hdiRanking;
  private double latitude;
  private double longitude;
  private double gdp;
}
