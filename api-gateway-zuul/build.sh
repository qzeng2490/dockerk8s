#!/usr/bin/env bash

source ~/.bash_profile
mvn package
docker build -t 192.168.56.102:8080/micro-service/api-gateway-zuul:latest .
docker push 192.168.56.102:8080/micro-service/api-gateway-zuul:latest