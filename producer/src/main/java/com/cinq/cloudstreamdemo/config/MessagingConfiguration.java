package com.cinq.cloudstreamdemo.config;

import com.cinq.cloudstreamdemo.messaging.BrazilCitiesProducerChannel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;

/**
 * Configures Spring Cloud Stream support.
 *
 * This works out-of-the-box if you use the Docker Compose configuration at "src/main/docker/kafka.yml".
 *
 * See http://docs.spring.io/spring-cloud-stream/docs/current/reference/htmlsingle/ for the official Spring Cloud Stream documentation.
 */
@EnableBinding(value = {BrazilCitiesProducerChannel.class})
public class MessagingConfiguration {

  @Value("${spring.application.name:brazil-cities-data-producer}")
  private String applicationName;

}
