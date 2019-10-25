#!/usr/bin/env bash

aws cloudformation package --template-file sam-native.yaml \
                             --output-template-file packaged-sam.yaml \
                             --s3-bucket oci-oss-work

aws cloudformation deploy --template-file ./packaged-sam.yaml --stack-name MicronautGraalVmDemo --capabilities CAPABILITY_IAM
aws cloudformation describe-stacks --stack-name MicronautGraalVmDemo --query "Stacks[0].Outputs[0].OutputValue" > url.txt

# Read url.txt, remove the "" surrounding the URL, replace $name with some trial names, curl those URLs, assert "Hello, NAME!" is returned