package com.cinq.cloudstraeamdemo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Property {

  private String operation;
  private String type;
  private String placeName;
  private String country;
  private String state;
  private String city;
  private double price;
  private String currency;
  private double priceUsd;
  private int rooms;
}
