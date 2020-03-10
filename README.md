# Help for developers

## Running The entire application using docker and swarm

1. Build applications using docker. Enter in each sub-folder and type

    `./gradlew clean build buildDocker`

2. Create network (one time only)

     `docker network create --driver overlay --attachable demo_net`

3. If you didn't before, enable swarm (one time only)

    `docker swarm init`
    
    `docker swarm join`

4. Create directory structure to store kafka / zookeeper data

    `mkdir confluentdata`

    `mkdir confluentdata/kafka`

    `mkdir confluentdata/zookeeper`

    `mkdir confluentdata/zookeeper-logs`

5. Run 

      `docker stack deploy --with-registry-auth -c docker/demo-swarm.yml dev`

6. Stop

    `docker stack rm dev`


## Running mysql and docker and the applications and each service in a separate process

1. Run the services

    `docker-compose -f docker/services.yml up -d`

2. Run each service independently. Go to the sub-folder and type:

    `java -jar .\build\libs\kafka-mysql-spring-producer-0.0.1-SNAPSHOT.jar`

    `java -jar .\build\libs\kafka-mysql-spring-consumer-0.0.1-SNAPSHOT.jar`
   