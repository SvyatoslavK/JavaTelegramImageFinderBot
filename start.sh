#!/bin/bash

git pull
mvn clean package
docker-compose stop
export BOT_USERNAME=$1
export BOT_TOKEN=$2
export password=$3
docker-compose up --build -d