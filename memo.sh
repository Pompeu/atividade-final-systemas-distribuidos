#!/usr/bin/env bash
i=0
#top -b -n1 | grep -e Mem: | awk '{print }' >> memo-
while [[ i -lt 500 ]]; do
	top -b -n1 | grep -e Mem: | awk '{print $4}' >> memo- $1
	sleep 1
	i=$[$i+1]
done

