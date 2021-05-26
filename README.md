# Spring-Boot RabbitMQ example

Some lines of code to define a sender and receiver programmatically.

Exchanges are defined by sender as beans to create them before sending first messages. 
I've observed that if you do this on demand via @QueryBinding then the first sent messages get lost.

The binding itself is created by receiver using @QueryBinding annotation.

Setup defined by docker-compose to simulate scaling of receiver with two instances.