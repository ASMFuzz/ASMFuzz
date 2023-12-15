#!/bin/bash

echo "01 copy cpp file to objs ..."

ls build/linux-x86_64-normal-server-release/hotspot/variant-server/libjvm/objs/*.cmdline | while read file
do
    cat $file | while read line
    do
        cpppath=$(echo $line | rev | cut -d " " -f 1 | sed 's/ //g' | rev)
        echo $cpppath
        if [ "$cpppath" != "true" ]; then
            echo $cpppath
            cp $cpppath build/linux-x86_64-normal-server-release/hotspot/variant-server/libjvm/objs/
        fi
    done
done

cp ./build/linux-x86_64-normal-server-release/hotspot/variant-server/support/adlc/ad_x86.cpp ./build/linux-x86_64-normal-server-release/hotspot/variant-server/libjvm/objs/
cp ./build/linux-x86_64-normal-server-release/hotspot/variant-server/support/adlc/ad_x86.hpp ./build/linux-x86_64-normal-server-release/hotspot/variant-server/libjvm/objs/
cp ./build/linux-x86_64-normal-server-release/hotspot/variant-server/support/adlc/ad_x86.hpp ./make/hotspot/
cp ./build/linux-x86_64-normal-server-release/hotspot/variant-server/support/adlc/ad_x86.cpp ./make/hotspot/
cp ./build/linux-x86_64-normal-server-release/hotspot/variant-server/support/adlc/ad_x86_gen.cpp ./make/hotspot/
cp ./build/linux-x86_64-normal-server-release/hotspot/variant-server/support/adlc/ad_x86_expand.cpp ./make/hotspot/
cp ./build/linux-x86_64-normal-server-release/hotspot/variant-server/support/adlc/ad_x86_misc.cpp ./make/hotspot/
cp ./build/linux-x86_64-normal-server-release/hotspot/variant-server/support/adlc/ad_x86_clone.cpp ./make/hotspot/
cp ./build/linux-x86_64-normal-server-release/hotspot/variant-server/support/adlc/dfa_x86.cpp ./make/hotspot/
cp ./build/linux-x86_64-normal-server-release/hotspot/variant-server/support/adlc/ad_x86_pipeline.cpp ./make/hotspot/
cp ./build/linux-x86_64-normal-server-release/hotspot/variant-server/support/adlc/ad* ./make/hotspot/
cp ./src/hotspot/cpu/x86/x86_64.ad ./build/linux-x86_64-normal-server-release/hotspot/variant-server/libjvm/objs/
cp ./src/hotspot/cpu/x86/x86_64.ad ./build/linux-x86_64-normal-server-release/hotspot/variant-server/libjvm/objs/src/hotspot/cpu/x86/
cp -r ./src ./build/linux-x86_64-normal-server-release/hotspot/variant-server/libjvm/objs
cp -r ./src ./make/hotspot/