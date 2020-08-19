package com.cinq.cloudstreamdemo.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class City {

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
