package com.cinq.cloudstraeamdemo;

import com.cinq.cloudstraeamdemo.service.ParseAndQueueData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@Slf4j
public class CloudStreamDemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(CloudStreamDemoApplication.class, args);
		ParseAndQueueData service = context.getBean(ParseAndQueueData.class);

		log.info("Beginning consumer...");
		service.parseFilesAndProduce();
		log.info("Done");
	}
}
