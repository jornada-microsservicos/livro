#!/bin/bash
echo "[INFO] ------------------------------------------------------------------------"
echo "[INFO] STOP CONTAINERS"
echo "[INFO] ------------------------------------------------------------------------"

docker stop service-gateway && docker rm -f service-gateway;
docker stop service-discovery && docker rm -f service-discovery;
docker stop micro-servico-extrato && docker rm -f micro-servico-extrato;
docker stop bff-mobile && docker rm -f bff-mobile;
