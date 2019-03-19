#!/usr/bin/env bash

source ~/.bash_profile

docker build -t 192.168.56.102:8080/micro-service/message-thrift-python-service:latest .
docker push 192.168.56.102:8080/micro-service/message-thrift-python-service:latest