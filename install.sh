#!/bin/sh
./gradlew build buildDocker
docker-compose -p weight-control -f src/main/docker/docker-compose.yml up -d
