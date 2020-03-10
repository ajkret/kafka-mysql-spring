package com.cinq.cloudstreamdemo.repository;

import com.cinq.cloudstreamdemo.domain.City;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {

  public List<City> findAllByStateOrderByState(String state);
}
