#!/bin/bash

data=$1
url=http://localhost:9000/payments

curl -d "$data" -H "Content-Type: application/json" -X POST ${url}
