package com.cinq.cloudstreamdemo.service;

import com.cinq.cloudstreamdemo.domain.City;
import com.cinq.cloudstreamdemo.dto.CityDto;
import com.cinq.cloudstreamdemo.messaging.BrazilCitiesConsumerChannel;
import com.cinq.cloudstreamdemo.repository.CityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ConsumerService {

  private final CityRepository repository;

  public ConsumerService(final CityRepository repository) {
    this.repository = repository;
  }

  @StreamListener(BrazilCitiesConsumerChannel.CHANNEL)
  public void consume(final CityDto incoming) {

    log.debug("Message received {}", incoming.toString());

    City city = convertForPersistence(incoming);

    city = repository.save(city);

    log.info("City persisted {}", city);

  }

  private City convertForPersistence(final CityDto incoming) {
    City city = new City();

    city.setCity(incoming.getCity());
    city.setDomesticUnits(incoming.getDomesticUnits());
    city.setForeigners(incoming.getForeigners());
    city.setGdp(incoming.getGdp());
    city.setHdiRanking(incoming.getHdiRanking());
    city.setLatitude(incoming.getLatitude());
    city.setLongitude(incoming.getLongitude());
    city.setPopulation(incoming.getPopulation());
    city.setResidents(incoming.getResidents());
    city.setState(incoming.getState());

    return city;
  }

}
