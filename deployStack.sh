#!/bin/bash

echo "inicializa o cluster swarm"

docker swarm init

docker stack deploy -c docker-compose.yml build

docker stack services build

echo "build rodando localhost:8080"