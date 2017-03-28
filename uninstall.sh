#!/bin/sh
docker-compose -p weight-control -f src/main/docker/docker-compose.yml down
if [ $(docker images -aq --filter reference=weightcontrol-api) ]; then
    docker rmi -f $(docker images -aq --filter reference=weightcontrol-api)
else
    echo Already removed!
fi


