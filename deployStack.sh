#!/bin/bash

echo "inicializa o cluster swarm"

docker swarm init

docker stack deploy -c docker-compose.yml service-mysql-spring-boot

docker stack services service-mysql-spring-boot

echo "service-mysql-spring-boot rodando localhost:8080"