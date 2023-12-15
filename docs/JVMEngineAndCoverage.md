# JVM installation and code coverage instrumentation

1. `apt update && apt upgrade`
2. ```shell
    apt install -y autoconf libx11-dev libxext-dev libxrender-dev \
    libxtst-dev libxt-dev libasound2-dev libcups2-dev \
    libfontconfig1-dev unzip zip apt-utils autoconf build-essential file \
    libxrandr-dev lcov
    ```
3. Install JDK

    ```
    1. wget https://download.java.net/java/GA/jdk20.0.2/6e380f22cbe7469fa75fb448bd903d8e/9/GPL/openjdk-20.0.2_linux-x64_bin.tar.gz
    2. tar -zxvf openjdk-20.0.2_linux-x64_bin.tar.gz
    3. rm openjdk-20.0.2_linux-x64_bin.tar.gz  
    ```

    ```
    1. wget https://download.oracle.com/java/17/latest/jdk-17_linux-x64_bin.tar.gz
    2. tar -zxvf jdk-17_linux-x64_bin.tar.gz  
    3. rm jdk-17_linux-x64_bin.tar.gz
    ```

4. Compile the latest version of OpenJDK directly (cd /root/jdk/)
    ```
    1. git clone https://github.com/openjdk/jdk.git
    2. bash configure --with-boot-jdk=/root/bootjdk/jdk-20.0.2
    3. make images
    ```

5. Code coverage analysis
    1. Code instrumentation
        1. `git clone https://github.com/openjdk/jdk11u-dev.git`
        2. `bash configure --enable-native-coverage --disable-warnings-as-errors --with-boot-jdk=/root/bootjdk/jdk-11.0.19/`
        3. `make images`
    2. Generate code coverage-related files
        1. `cd build/linux-x86_64-normal-server-release/hotspot/variant-server/libjvm/objs/`
        2. `lcov -b ./ -d ./ --rc lcov_branch_coverage=1 --gcov-tool /usr/bin/gcov -c -o /root/jvm/jdk11u-dev/output.info`
    3. Need to copy a bunch of files
            The copy scripts below have already been integrated into /root/shannonfuzz/fuzz/scripts/coverage_copy.sh. If executed, they will directly copy the files to the target directory of the engine to be compiled. After executing the 'ls' command, there should be a 'build' folder. After using 'chmod +x' to elevate privileges, you can directly execute it.
        ```shell
           
        # #!/bin/bash
           
        echo "01 copy cpp file to objs ..."
           
        ls /root/buildjvm/jdk18/build/linux-x86_64-server-release/hotspot/variant-server/libjvm/objs/*.cmdline | while read file
        do
        cat $file | while read line
        do
        cpppath=`echo $line | rev | cut -d " " -f 1 | sed 's/ //g' | rev`
        if [ "$cpppath" != "true" ]; then
        echo $cpppath
        cp $cpppath /root/buildjvm/jdk18/build/linux-x86_64-server-release/hotspot/variant-server/libjvm/objs/
        fi
        done
        done
           
        ```   
        ```
           cp build/linux-x86_64-server-release/hotspot/variant-server/support/adlc/ad_x86.cpp build/linux-x86_64-server-release/hotspot/variant-server/libjvm/objs/
           cp build/linux-x86_64-server-release/hotspot/variant-server/support/adlc/ad_x86.hpp /root/buildjvm/jdk18/build/linux-x86_64-server-release/hotspot/variant-server/libjvm/objs/
           cp src/hotspot/cpu/x86/x86_64.ad /root/buildjvm/jdk18/build/linux-x86_64-server-release/hotspot/variant-server/libjvm/objs/
           cp src/hotspot/cpu/x86/x86_64.ad /root/buildjvm/jdk18/build/linux-x86_64-server-release/hotspot/variant-server/libjvm/objs/src/hotspot/cpu/x86/
           cp -r ./src /root/buildjvm/jdk18/build/linux-x86_64-server-release/hotspot/variant-server/libjvm/objs/
        ```
    4. After obtaining the 'output.info' file, execute the following:
       `genhtml --rc genhtml_branch_coverage=1 -o HtmlFile output.info`
