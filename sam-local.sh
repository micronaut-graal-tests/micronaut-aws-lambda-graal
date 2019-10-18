#!/bin/sh
docker build . -t micronaut-aws-lambda-graal
mkdir -p build
docker run --rm --entrypoint cat micronaut-aws-lambda-graal  /home/application/function.zip > build/function.zip

sam local start-api -t sam.yaml -p 3000

