#!/usr/bin/env bash

source ~/.bash_profile

docker build -t message-thrift-python-service:latest .
#docker push message-thrift-python-service:latest