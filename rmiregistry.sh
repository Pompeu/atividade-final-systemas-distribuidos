#!/usr/bin/env bash
i=0
while [[ i -lt 250 ]]; do
	top -bn1 | grep -e rmiregistry | awk '{print  $9, $10}'
	sleep 1
	i=$[$i+1]
done


