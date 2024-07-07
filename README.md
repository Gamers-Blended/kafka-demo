# kafka-demo
A simple example of using Apache Kafka

## What is Kafka?
Kafka acts as a message broker between producer and consumer.<br>
![image](https://github.com/Gamers-Blended/kafka-demo/assets/47865641/9e807632-32e5-4c10-b21b-6b660c61d63e)<br>
Fault-tolerant: If 1 or more broker is down, it can distribute to other nodes<br>
A cluster consists of a set of brokers.

Zookeeper is a service that manages the state of brokers and configurations.

## Topic
Need identification mechanism to request which data to pull from broker.<br>
Topics are an ordered collection of events that are stored in a durable way (written to more than 1 server/disk and replicated).<br>
Like a table in database or folder in file system.<br>
Identified by unique name.<br>
Can have any number of topics.

## Partitions
Topics are divided into partitions, which contain records in an unchangeable sequence.<br>
Brokers store messages for a topic.<br>
But may not have enough capacity to store in a single computer.<br>
Thus, we can partition the messages into multiple parts and distribute among multiple computers.

## Offsets
Sequence of IDs given to messages as they arrive at a partition.<br>
Once assigned, never changed.<br>
First message offset = 0<br>
Next offset = 1 and so on…<br>
![image](https://github.com/Gamers-Blended/kafka-demo/assets/47865641/a09ff32d-4f33-4c99-80b4-c9db80ff05df)

## JSON Serializer and Deserializer
Stores and transports byte[].<br>
Kafka can convert Java objects to and from JSON.

application.properties
```
spring.kafka.consumer.auto-offset-reset
# What to do when no initial offset for Kafka or if the current offset doesn’t exist

spring.kafka.consumer.properties.spring.json.trusted.packages
# Kafka consumer can deserialise all classes from stated package

```
If trusted packages isn't set, this error will occur:
```
Caused by: java.lang.IllegalArgumentException: The class 'com.sample.kafka_demo.dto.User' is not in the trusted packages: [java.util, java.lang]. If you believe this class is safe to deserialize, please provide its name. If the serialization is only done by a trusted source, you can also enable trust all (*).
```

## To Start Server With Docker
Refer to (https://kafka.apache.org/quickstart) for steps on how to setup kafka.

Get the Docker image
```
$ docker pull apache/kafka:x.x.x
```

Start the kafka docker container
```
$ docker run -p 9092:9092 apache/kafka:x.x.x
```

## Event-Driven Architecture (EDA)
Kafka is an example of an EDA.<br>
EDA is a design pattern in which decoupled applications can asynchronously publish and subscribe to events via event broker/message broker.<br>
Apps communicate by sending and/or receiving events or messages.
