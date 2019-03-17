#!/usr/bin/env bash

source ~/.bash_profile
mvn package
docker build -t course-edge-service:latest .
#docker push course-edge-service:latest