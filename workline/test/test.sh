#!/bin/bash  
    
if [ "$#" -ne 1 ]; then  
    echo "Usage: $0 <bytecode_file_path>"  
    exit 1  
fi  
    
BYTECODE_FILE="$1"  
   
  
JVMS=("/root/jvm/openjdk17/jdk-17.0.5+8/build/linux-x86_64-server-release/jdk/bin/java"  
      "/root/jvm/openjdk11/jdk-11.0.17+8/build/linux-x86_64-normal-server-release/jdk/bin/java"  
      "/root/jvm/openj9-jdk17/openj9-openjdk-jdk17/build/linux-x86_64-server-release/jdk/bin/java"
      "/root/jvm/openj9-jdk11/openj9-openjdk-jdk11/build/linux-x86_64-normal-server-release/jdk/bin/java"
      "/root/jvm/zulu-jdk17/zulu17.38.21-ca-jdk17.0.5-linux_x64/bin/java"
      "/root/jvm/zulu11.70.15-ca-jdk11.0.22-linux_x64/bin/java"
      "/root/jvm/graalvm-ce-java11-22.3.3/bin/java"
      "/root/jvm/graal-jdk17/graalvm-ce-java17-22.3.0/bin/java"
      "/root/jvm/jdk11u-dev/build/linux-x86_64-normal-server-release/jdk/bin/java" 
     )
a = 0   
for (( i=0; i<${#JVMS[@]}; i++ )) 
do 
    JVM="${JVMS[$i]}"
    echo "Running $BYTECODE_FILE with JVM #${a+1} ($JVM)"
    $JVM $BYTECODE_FILE    
    echo "--------------------------------#${a+1}--------------------------------------"  
    let a++
done
