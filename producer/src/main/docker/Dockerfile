FROM openjdk:8-jre-alpine

ENV SPRING_OUTPUT_ANSI_ENABLED=ALWAYS \
    JAVA_OPTS="-Dspring.profiles.active=default -Xmx2048m"

RUN adduser -D -s /bin/sh demoapp
WORKDIR /home/demoapp

ADD entrypoint.sh entrypoint.sh
RUN chmod 755 entrypoint.sh && chown demoapp:demoapp entrypoint.sh
RUN mkdir -p /home/demoapp/source && chown demoapp:demoapp /home/demoapp/source
USER demoapp

ADD *.jar app.jar

ENTRYPOINT ["./entrypoint.sh"]

EXPOSE 8080
