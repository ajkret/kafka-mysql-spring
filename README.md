# Help for developers

This folder contains two applications, a Producer and a Consumer using Kafka to pass messages.
Here the direct instructions on how to run them together, using docker.

## Running The entire application using docker and swarm

1. Build applications using docker. Enter in each sub-folder and type

    `./gradlew clean build buildDocker`

2. If you didn't before, enable swarm (one time only)

    `docker swarm init`

or

    `docker swarm join`

3. Create network (one time only)

     `docker network create --driver overlay --attachable demo_net`

4. Run 

      `docker stack deploy --with-registry-auth -c docker/demo-swarm.yml dev`

5. And when you wanto to stop

    `docker stack rm dev`


## Running mysql and docker and the applications and each service in a separate process

1. Run the services

    `docker-compose -f docker/services.yml up -d`

2. Run each service independently. Go to the sub-folder and type:

    `java -jar .\build\libs\kafka-mysql-spring-producer-0.0.1-SNAPSHOT.jar`

    `java -jar .\build\libs\kafka-mysql-spring-consumer-0.0.1-SNAPSHOT.jar`
   