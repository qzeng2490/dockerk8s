#!/usr/bin/env bash
source ~/.bash_profile
mvn package
docker build -t user-edge-service:latest .
#docker push user-edge-service:latest