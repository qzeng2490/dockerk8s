#!/usr/bin/env bash

source ~/.bash_profile
mvn package
docker build -t api-gateway-zuul:latest .
#docker push api-gateway-zuul:latest