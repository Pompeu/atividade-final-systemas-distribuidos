#!/usr/bin/env bash
i=0
#top -bn1 | grep "Cpu(s)" | awk '{print $2}'"
while [[ i -lt 500 ]]; do
	top -b -n1 | grep -e Cpu >> cpu-$1
	sleep 1
	i=$[$i+1]
done

