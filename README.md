# RabbitMQ Producer and Consumer applications

# Setup

## Start Rabbit server

```bash
C:\Program Files\RabbitMQ Server\rabbitmq_server-3.8.14\sbin>rabbitmq-server start
```

## Enable the RabbitMQ management plugin to access it using in the browser

```bash
C:\Program Files\RabbitMQ Server\rabbitmq_server-3.8.14\sbin>rabbitmq-plugins.bat enable rabbitmq_management
```

## Setup RabbitMQ Exchange and Queue
Go to ```http://localhost:15672``` and login with user/password: guest/guest

* Create exchange
  - Go to ```http://localhost:15672/#/exchanges```
  - Add exchange: jExchange
* Create queue
  - Go to ```http://localhost:15672/#/queues```
  - Add queue: JQueue
* Binding the queue with exchange
  - Open queue ```JQueue``` -> item ```Bindings```
  - Add binding with the following parameters
    * From exchange: ```jExchange```
    * Routing Key: ```jRoutingKey```
  - Click ```Bind``` button

## Run both applications and publish message
```
http://localhost:8080/rabbitmq/send?message=This is a message
```
Consumed message will be shown in RabbitMQConsumer app in log
