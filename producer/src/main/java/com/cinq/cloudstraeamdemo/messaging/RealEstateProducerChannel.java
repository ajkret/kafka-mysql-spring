package com.cinq.cloudstraeamdemo.messaging;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface RealEstateProducerChannel {

  @Output("realEstateProducerChannel")
  MessageChannel realEstateProducerChannel();

}
