package com.cinq.cloudstreamdemo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CItyRow {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false, updatable = false, unique = true)
  private Long id;

  @Column
  private String city;

  @Column
  private String state;

  @Column
  private long population;

  @Column
  private long residents;

  @Column
  private long foreigners;

  @Column(name="domestic_units")
  private long domesticUnits;

  @Column(name = "hdi_ranking")
  private double hdiRanking;

  @Column
  private double latitude;

  @Column
  private double longitude;

  @Column
  private double gdp;

}
