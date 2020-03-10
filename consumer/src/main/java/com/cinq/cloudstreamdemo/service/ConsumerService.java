package com.cinq.cloudstreamdemo.service;

import com.cinq.cloudstreamdemo.dto.City;
import com.cinq.cloudstreamdemo.messaging.BrazilCitiesConsumerChannel;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ConsumerService {

  @StreamListener(BrazilCitiesConsumerChannel.CHANNEL)
  public void consume(final City incoming) {

    log.debug("Message received {}", incoming.toString());

  }

}
