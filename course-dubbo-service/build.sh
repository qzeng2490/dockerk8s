#!/usr/bin/env bash

source ~/.bash_profile
mvn package
docker build -t course-dubbo-service:latest .
#docker push course-dubbo-service:latest