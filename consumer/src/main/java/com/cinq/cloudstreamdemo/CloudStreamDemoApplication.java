package com.cinq.cloudstreamdemo;

import io.micrometer.core.instrument.util.StringUtils;
import java.net.InetAddress;
import java.net.UnknownHostException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
@Slf4j
public class CloudStreamDemoApplication {

  public static void main(String[] args) {
    SpringApplication app = new SpringApplication(CloudStreamDemoApplication.class);
    Environment env = app.run(args).getEnvironment();
    logApplicationStartup(env);
  }

  private static void logApplicationStartup(Environment env) {
    String protocol = "http";
    if (env.getProperty("server.ssl.key-store") != null) {
      protocol = "https";
    }
    String serverPort = env.getProperty("server.port");
    String contextPath = env.getProperty("server.servlet.context-path");
    if (StringUtils.isBlank(contextPath)) {
      contextPath = "/";
    }
    String hostAddress = "localhost";
    try {
      hostAddress = InetAddress.getLocalHost().getHostAddress();
    } catch (UnknownHostException e) {
      log.warn("The host name could not be determined, using `localhost` as fallback");
    }
    log.info(
        "\n----------------------------------------------------------\n\t"
            + "Application '{}' is running! Access URLs:\n\t" + "Local: \t\t{}://localhost:{}{}\n\t"
            + "External: \t{}://{}:{}{}\n\t"
            + "Profile(s): \t{}\n----------------------------------------------------------",
        env.getProperty("spring.application.name"), protocol, serverPort, contextPath, protocol, hostAddress,
        serverPort, contextPath, env.getActiveProfiles());

    String configServerStatus = env.getProperty("configserver.status");
    if (configServerStatus == null) {
      configServerStatus = "Not found or not setup for this application";
    }
    log.info(
        "\n----------------------------------------------------------\n\t"
            + "Config Server: \t{}\n----------------------------------------------------------",
        configServerStatus);
  }
}
