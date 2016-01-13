#!/usr/bin/env bash

i=0

while [[ i -lt 500 ]]; do
	top -b -n1 | grep -e Mem: | awk '{print $5}'
	sleep 1
	i=$[$i+1]
done

