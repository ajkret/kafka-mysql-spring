package com.cinq.cloudstreamdemo.messaging;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface BrazilCitiesConsumerChannel {

  String CHANNEL = "brazilCitiesConsumerChannel";

  @Input(CHANNEL)
  SubscribableChannel consumerChannel();

}
