#!/bin/bash

folder_path="/root/asmfuzz/feature/src/test/data/detectFeature"

cd $folder_path

for file in *; do
    if [[ $file != *.java ]]; then
        rm $file
	echo $file
    fi
done
