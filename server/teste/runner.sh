#!/usr/bin/env bash

i=0
while [[ i -lt 1000 ]]; do
	/usr/bin/java Main >> sockets
	i=$[$i+1]
done
