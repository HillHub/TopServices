# DEVELOPMENT ENVIRONMENT SETUP

| File                 | Description                                                                                   |
|----------------------|-----------------------------------------------------------------------------------------------|
| zookeeper.yml        | Zookeeper lives here, must be started before kafka_standalone.yml                                |
| kafka_standalone.yml | Contains only one broker, UI, and schema registry, run this if you dont need all thre brokers |
| database.yml 		   | Contains microsoft sql database |


### Run the cluster

#### Run zookeeper

Start by running the zookeeper first
```shell
docker-compose -f zookeeper.yml up
```

#### Start kafka broker, schema registry and kafka-ui

Or run just one standalone broker
```shell
docker-compose  -f kafka_standalone.yml up
```

### Ports

| Port |                 |
|------|-----------------|
| 3030 | Kafka UI        |
| 8081 | Schema Registry |
| 9092 | Broker          |

## Database
Setup local database

```shell
docker-compose -f database.yml up
```