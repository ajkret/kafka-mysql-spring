package com.cinq.cloudstreamdemo.web.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ping")
@Slf4j
public class PingController {

  @GetMapping
  public String getPing() {
    log.info("Ping request");
    return "pong";
  }
}
