#!/bin/bash

echo "inicializa o cluster swarm"

docker swarm init

docker stack deploy -c docker-compose.yml build-spring

docker stack services build-spring

echo "build-spring rodando localhost:8080"