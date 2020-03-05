package com.cinq.cloudstraeamdemo.messaging;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface BrazilCitiesProducerChannel {

  @Output("brazilCitiesProducerChannel")
  MessageChannel brazilCitiesProducerChannel();

}
