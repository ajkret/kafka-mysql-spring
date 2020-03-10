package com.cinq.cloudstreamdemo.repository;

import com.cinq.cloudstreamdemo.domain.CItyRow;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<CItyRow, Long> {

  public List<CItyRow> findAllByStateOrderByState(String state);
}
