#!/usr/bin/env bash
i=0
while [[ i -lt 500 ]]; do
	top -bn1 | grep "Cpu(s)" | awk '{print $2}'"
	sleep 1
	i=$[$i+1]
done

