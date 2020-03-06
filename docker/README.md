# Help for developers

## Running Kafka and MySQL locally using Docker

1. Create network (one time only)

     `docker network create --driver overlay --attachable demo_net`

2. If you didn't before, enable swarm (one time only)

    `docker swarm init`
    
    `docker swarm join`

3. Create directory structure to store kafka / zookeeper data

    `mkdir confluentdata`

    `mkdir confluentdata/kafka`

    `mkdir confluentdata/zookeeper`

    `mkdir confluentdata/zookeeper-logs`

4. Run 

      `docker stack deploy --with-registry-auth -c ./dev-compose.yml dev`


## Stoping 
```
docker stack rm dev
```

# Check containers joined network
```
docker network inspect demo_net
```

# Create a topic
```
docker run --network=demo_net --rm confluentinc/cp-kafka:4.1.2 kafka-topics --zookeeper zookeeper:2181 --replication-factor 1 --partitions 1 --create --topic testTopic
```

# List Topics
```
docker run --network=demo_net --rm confluentinc/cp-kafka:4.1.2 kafka-topics --list --zookeeper zookeeper:2181
```

# Describe Topics
```
docker run --network=demo_net --rm confluentinc/cp-kafka:4.1.2 kafka-topics --describe --zookeeper zookeeper:2181
```

# Publish some data to our new topic `testtopic` using the built-in `Kafka Console Producer`
```
docker run --network=demo_net --rm confluentinc/cp-kafka:4.1.2 bash -c "seq 10 | kafka-console-producer --request-required-acks 1 --broker-list kafka:9092 --topic testTopic && echo 'Gman you produced 10 messages.'"
```

Upon running it, you should see the following:
```
Gman you produced 10 messages.
```

# Consume Read back the messages using the built-in `Console consumer`
```
docker run --network=demo_net --rm confluentinc/cp-kafka:4.1.2 kafka-console-consumer --bootstrap-server kafka:9092 --topic testTopic --new-consumer testconsumer --from-beginning --max-messages 10
```

Each of the original messages we produced should be written back out:
```
1
....
10
Proccessed a total of 10 messages
```
