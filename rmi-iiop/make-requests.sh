#!/usr/bin/env bash
i=0

while [[ i -lt 1000 ]]; do
	./testes/client.sh >> iiop
	i=$[$i+1]
done
