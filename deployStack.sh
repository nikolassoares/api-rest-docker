#!/bin/bash

echo "inicializa o cluster swarm"

docker swarm init

docker stack deploy -c docker-compose.yml spring-boot-service

docker stack services spring-boot-service

echo "spring-boot-service rodando localhost:8080"