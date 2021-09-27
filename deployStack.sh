#!/bin/bash

echo "inicializa o cluster swarm"

docker swarm init

docker stack deploy -c docker-compose.yml db-mysql-service

docker stack services db-mysql-service

echo "service-mysql-spring-boot rodando localhost:8080"