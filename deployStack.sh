#!/bin/bash

echo "inicializa o cluster swarm"

docker swarm init

docker stack deploy -c docker-compose.yml stack-service

docker stack services stack-service

echo "stack-service rodando localhost:8080"