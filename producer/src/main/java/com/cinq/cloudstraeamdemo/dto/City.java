package com.cinq.cloudstraeamdemo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
