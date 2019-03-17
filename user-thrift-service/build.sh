#!/usr/bin/env bash
source ~/.bash_profile
mvn package
docker build -t user-thrift-service:latest .
#docker push user-thrift-service:latest