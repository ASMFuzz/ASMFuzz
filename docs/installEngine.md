##### The currently selected differential testing engine includes:

OpenJDK(HotSpot), IBM-OpenJ9, Azul-Zulu JVM, Oracle-GraalVM, Tencent-Kona  

###### OpenJDK(HotSpot)

```
Source code download:
https://openjdk-sources.osci.io/openjdk8/
https://openjdk-sources.osci.io/openjdk11/

Check the recent updates of the engine:
https://mail.openjdk.java.net/pipermail/jdk8u-dev/
https://mail.openjdk.java.net/pipermail/jdk-updates-dev/

All update logs for OpenJDK:
https://builds.shipilev.net/backports-monitor/

Java report submission system:
https://bugs.openjdk.java.net/secure/Dashboard.jspa

Installation command: (Use chmod +x ./configure to increase script permissions)
jdk8：
./configure (You may need to use the command sudo apt-get install openjdk-8-jdk to install JDK as the bootjdk)
make all

Check the version:
./build/*/jdk/bin/java -version
jdk11:
Firstly, check if there is an available bootjdk. If not, download JDK of version N-1 or N-2 and add the path after --with-boot-jdk
./configure --with-boot-jdk=/root/jvm/jdk-10
 make images
OR make all
Check the version:
./build/*/images/jdk/bin/java -version

```

###### IBM-OpenJ9

```
Source code download: Make sure to update all repositories during the "Get Source Code" step.
https://github.com/eclipse-openj9/openj9
https://github.com/ibmruntimes/openj9-openjdk-jdk8
https://github.com/eclipse-openj9/openj9-omr

Here is a step-by-step guide on how to install:
https://github.com/eclipse-openj9/openj9/tree/master/doc/build-instructions/Build_Instructions_V8.md
https://github.com/eclipse-openj9/openj9/blob/master/doc/build-instructions/Build_Instructions_V11.md
Installation steps:
Get environment dependency information:
wget https://raw.githubusercontent.com/eclipse-openj9/openj9/master/buildenv/docker/mkdocker.sh
bash mkdocker.sh --tag=openj9 --dist=ubuntu --version=18.04 --print
Configure dependencies:
sudo apt-get install -qq -y --no-install-recommends software-properties-common
sudo add-apt-repository ppa:ubuntu-toolchain-r/test
sudo apt-get install -qq -y --no-install-recommends ant ant-contrib autoconf build-essential ca-certificates cmake cpio curl file g++-7 gcc-7 gdb git libasound2-dev libcups2-dev libdwarf-dev libelf-dev libexpat1-dev libffi-dev libfontconfig  libfontconfig1-dev libfreetype6-dev libnuma-dev libssl-dev libx11-dev libxext-dev libxrandr-dev libxrender-dev libxt-dev libxtst-dev nasm openssh-client openssh-server perl pkg-config systemtap-sdt-dev wget xvfb zlib1g-dev
sudo rm -rf /var/lib/apt/lists/*
export CC=gcc-7 CXX=g++-7

Configure Boot JDK:
wget -O bootjdk8.tar.gz https://api.adoptopenjdk.net/v3/binary/latest/8/ga/linux/x64/jdk/openj9/normal/adoptopenjdk
tar -xzf bootjdk8.tar.gz
rm -f bootjdk8.tar.gz
mv $(ls | grep -i jdk8) bootjdk8

Get source code (including the latest versions of the openj9-openjdk-jdk8, omr, and openj9 repositories):
git clone https://github.com/ibmruntimes/openj9-openjdk-jdk8.git
cd openj9-openjdk-jdk8
bash get_source.sh

Compile and install:
bash configure --with-boot-jdk=/root/jvm/bootjdk8
make all
Check version:
cd build/linux-x86_64-normal-server-release/images/j2re-image
./bin/java -version

The above output includes the version information for each repository, for example:
OpenJ9   - 68d6fdb
OMR      - 7c3d3d7
OpenJDK  - 27f5b8f (based on jdk8u152-b03)

```

###### Azul-Zulu JVM

```
Source code download:
https://www.azul.com/downloads/?version=java-8-lts&os=ubuntu&architecture=x86-64-bit&package=jdk
https://www.azul.com/downloads/?version=java-11-lts&os=ubuntu&architecture=x86-64-bit&package=jdk
Choose the corresponding Java version, operating system, architecture, and Java package, and download the installation package in .tar.gz format.
```

###### Oracle-GraalVM

```
Release update log:
https://www.graalvm.org/release-notes/version-roadmap/
https://www.graalvm.org/release-notes/21_3/
https://www.graalvm.org/release-notes/21_2/
Source code download:
Official website: https://www.graalvm.org/downloads/
Github：
https://github.com/graalvm/graalvm-ce-builds/releases/tag/vm-21.3.0
https://github.com/graalvm/graalvm-ce-builds/releases/tag/vm-21.2.0
Choose the Linux installation package from the list of "Java 11 based," "Java 17 based," and "Java 8 based."
```

###### Tencent-Kona  

```
Source code download:
https://github.com/Tencent/TencentKona-8/releases
https://github.com/Tencent/TencentKona-11/releases
Extract directly.
```
###### Engine installation in server docker:

| Engine name |  JDK version   |      Engine release version                        | Engine release date |
| :------: | :--------: | :----------------------------------------------------------: | :----------: |
| OpenJDK  |  8.0.312   | [8.0.312](https://mail.openjdk.java.net/pipermail/jdk8u-dev/2021-October/014373.html) |  2021.10.20  |
| OpenJDK  |  11.0.13   | [11.0.13](https://mail.openjdk.java.net/pipermail/jdk-updates-dev/2021-October/009368.html) |  2021.10.20  |
|  OpenJ9  | 8u312-b07  | OpenJ9:[239de6a](https://github.com/eclipse-openj9/openj9/commit/239de6af138a58e77040ba72c3b638bc01831a47)/OMR:[3e22bee](https://github.com/eclipse-openj9/openj9-omr/commit/3e22bee4ac1843c2aaf5ac3578b8ba7e7dca3334)/JCL:[9ba2987](https://github.com/ibmruntimes/openj9-openjdk-jdk8/commit/9ba2987b7f26b62b76b91399d4eb5c8ed4aecd94) |  2021.11.11  |
|  OpenJ9  | 11.0.14+1  | OpenJ9:[239de6a](https://github.com/eclipse-openj9/openj9/commit/239de6af138a58e77040ba72c3b638bc01831a47)/OMR:[3e22bee](https://github.com/eclipse-openj9/openj9-omr/commit/3e22bee4ac1843c2aaf5ac3578b8ba7e7dca3334)/JCL:[fc2dbe5](https://github.com/ibmruntimes/openj9-openjdk-jdk11/commit/fc2dbe59e18618ddd6bb0ea5b5926efe172dec23) |  2021.11.11  |
| Zulu JVM | 8u312-b07  | [8.58.0.13](https://cdn.azul.com/zulu/bin/zulu8.58.0.13-ca-jdk8.0.312-linux_x64.tar.gz) |  2021.10.19  |
| Zulu JVM | 11.0.13+8  | [11.52.13](https://cdn.azul.com/zulu/bin/zulu11.52.13-ca-jdk11.0.13-linux_x64.tar.gz) |  2021.10.19  |
| GraalVM  | 8u312-b07  | [21.2.0.1](https://github.com/graalvm/graalvm-ce-builds/releases/tag/vm-21.2.0) |  2021-08-04  |
| GraalVM  | 11.0.13+7  | [21.3.0](https://github.com/graalvm/graalvm-ce-builds/releases/tag/vm-21.3.0) |  2021-10-19  |
|   Kona   |  8.0.302   | [v8.0.7-GA](https://github.com/Tencent/TencentKona-8/releases/tag/8.0.7-GA) |  2021.08.23  |
|   Kona   | 11.0.12-ga | [11.0.12-GA for Fiber](https://github.com/Tencent/TencentKona-11/releases/tag/kona11.0.12-fiber) |  2021.09.06  |

###### Engine installation
| Engine name |   JDK version   |                       Engine release version                        | Engine update time |
| :------: | :---------: | :----------------------------------------------------------: | :----------: |
| OpenJDK  |   8.0.332   | [8.0.332](https://openjdk-sources.osci.io/openjdk8/openjdk8u332-b02-ea.tar.xz) |   2022.2.8   |
| OpenJDK  |   11.0.14   | [11.0.14](https://openjdk-sources.osci.io/openjdk11/openjdk-11.0.14-ga.tar.xz) |  2022.1.20   |
|  OpenJ9  |  8u332-b02  | OpenJ9:[39c490eaf](https://github.com/eclipse-openj9/openj9/commit/39c490eafcafe340112ed2820f9ae347eba58052)/OMR:[b63287860](https://github.com/eclipse-openj9/openj9-omr/commit/b63287860e6f8c542cffd4056855a9e5d280500d)/JCL:[301202f49f](https://github.com/ibmruntimes/openj9-openjdk-jdk8/commit/301202f49fd1513d9e6f0f2d3cba82a4d4e3a5a7) |  2022.2.17   |
|  OpenJ9  |  11.0.15+1  | OpenJ9:[39c490eaf](https://github.com/eclipse-openj9/openj9/commit/39c490eafcafe340112ed2820f9ae347eba58052)/OMR:[b63287860](https://github.com/eclipse-openj9/openj9-omr/commit/b63287860e6f8c542cffd4056855a9e5d280500d)/JCL:[24e7209ed4](https://github.com/ibmruntimes/openj9-openjdk-jdk11/commit/24e7209ed423886e9be7506f55428369d81bdd42) |  2022.2.17   |
| Zulu JVM |  8u322-b06  | [8.60.0.21](https://cdn.azul.com/zulu/bin/zulu8.60.0.21-ca-jdk8.0.322-linux_x64.tar.gz) |  2022.1.18   |
| Zulu JVM | 11.0.14.1+1 | [11.54.25](https://cdn.azul.com/zulu/bin/zulu11.54.25-ca-jdk11.0.14.1-linux_x64.tar.gz) |  2022.2.15   |
| GraalVM  |  11.0.14+9  | [22.0.0.2](https://github.com/graalvm/graalvm-ce-builds/releases/tag/vm-22.0.0.2) |  2022.1.18   |
|   Kona   | 8.0.322-b1  | [8.0.9-GA](https://github.com/Tencent/TencentKona-8/releases/tag/8.0.9-GA) |  2022.2.16   |
|   Kona   |  11.0.14+1  | [11.0.14-GA](https://github.com/Tencent/TencentKona-11/releases/tag/kona11.0.14) |  2022.2.16   |
###### Docker executable paths for javac compilation and java execution on server XX:
```
TencentKona-8：
/JVMfuzzing/wy/engines/TencentKona-8/TencentKona-8.0.7-302/bin/javac
/JVMfuzzing/wy/engines/TencentKona-8/TencentKona-8.0.7-302/bin/java
TencentKona-11：
/JVMfuzzing/wy/engines/TencentKona-11/TencentKona-11.0.12.b1_fiber/bin/javac
/JVMfuzzing/wy/engines/TencentKona-11/TencentKona-11.0.12.b1_fiber/bin/java
Openjdk8：
/JVMfuzzing/wy/engines/openjdk8/jdk8u312-ga/build/linux-x86_64-normal-server-release/jdk/bin/javac
/JVMfuzzing/wy/engines/openjdk8/jdk8u312-ga/build/linux-x86_64-normal-server-release/jdk/bin/java
Openjdk11：
/JVMfuzzing/wy/engines/openjdk11/jdk-11.0.13-ga/build/linux-x86_64-normal-server-release/images/jdk/bin/javac
/JVMfuzzing/wy/engines/openjdk11/jdk-11.0.13-ga/build/linux-x86_64-normal-server-release/images/jdk/bin/java
Zulu-v8：
/JVMfuzzing/wy/engines/zulu/zulu8.58.0.13-ca-jdk8.0.312-linux_x64/bin/javac
/JVMfuzzing/wy/engines/zulu/zulu8.58.0.13-ca-jdk8.0.312-linux_x64/bin/java
Zulu-v11：
/JVMfuzzing/wy/engines/zulu/zulu11.52.13-ca-jdk11.0.13-linux_x64/bin/javac
/JVMfuzzing/wy/engines/zulu/zulu11.52.13-ca-jdk11.0.13-linux_x64/bin/java
Openj9-v8：
/JVMfuzzing/wy/engines/openj9/openj9-openjdk-jdk8/build/linux-x86_64-normal-server-release/images/j2sdk-image/bin/javac
/JVMfuzzing/wy/engines/openj9/openj9-openjdk-jdk8/build/linux-x86_64-normal-server-release/images/j2sdk-image/bin/java
Openj9-v11：
/JVMfuzzing/wy/engines/openj9/openj9-openjdk-jdk11/build/linux-x86_64-normal-server-release/images/jdk/bin/javac
/JVMfuzzing/wy/engines/openj9/openj9-openjdk-jdk11/build/linux-x86_64-normal-server-release/images/jdk/bin/java
GraalVM_v8:
/JVMfuzzing/wy/engines/graalvm_v8/graalvm-ce-java8-21.2.0/bin/javac
/JVMfuzzing/wy/engines/graalvm_v8/graalvm-ce-java8-21.2.0/bin/java
GraalVM_v11:
/JVMfuzzing/wy/engines/graalvm_v11/graalvm-ce-java11-21.3.0/bin/javac
/JVMfuzzing/wy/engines/graalvm_v11/graalvm-ce-java11-21.3.0/bin/java
```

###### Docker executable paths for javac compilation and java execution on XXX server:

```
TencentKona-8：
/root/jvm/kona-jdk8/TencentKona-8.0.9-322/bin/javac
/root/jvm/kona-jdk8/TencentKona-8.0.9-322/bin/java
TencentKona-11：
/root/jvm/kona-jdk11/TencentKona-11.0.14.b1/bin/javac
/root/jvm/kona-jdk11/TencentKona-11.0.14.b1/bin/java
Openjdk8：
/root/jvm/openjdk8/jdk8u322-b04/build/linux-x86_64-normal-server-release/jdk/bin/javac
/root/jvm/openjdk8/jdk8u322-b04/build/linux-x86_64-normal-server-release/jdk/bin/java
Openjdk11：
/root/jvm/openjdk11/jdk-11.0.14-ga/build/linux-x86_64-normal-server-release/images/jdk/bin/javac
/root/jvm/openjdk11/jdk-11.0.14-ga/build/linux-x86_64-normal-server-release/images/jdk/bin/java
Zulu-v8：
/root/jvm/zulu-jdk8/zulu8.60.0.21-ca-jdk8.0.322-linux_x64/bin/javac
/root/jvm/zulu-jdk8/zulu8.60.0.21-ca-jdk8.0.322-linux_x64/bin/java
Zulu-v11：
/root/jvm/zulu-jdk11/zulu11.54.25-ca-jdk11.0.14.1-linux_x64/bin/javac
/root/jvm/zulu-jdk11/zulu11.54.25-ca-jdk11.0.14.1-linux_x64/bin/java
Openj9-v8：
/root/jvm/openj9-jdk8/openj9-openjdk-jdk8/build/linux-x86_64-normal-server-release/images/j2sdk-image/bin/javac
/root/jvm/openj9-jdk8/openj9-openjdk-jdk8/build/linux-x86_64-normal-server-release/images/j2sdk-image/bin/java
Openj9-v11：
/root/jvm/openj9-jdk11/openj9-openjdk-jdk11/build/linux-x86_64-normal-server-release/images/jdk/bin/javac
/root/jvm/openj9-jdk11/openj9-openjdk-jdk11/build/linux-x86_64-normal-server-release/images/jdk/bin/java
GraalVM_v11:
/root/jvm/graal-jdk11/graalvm-ce-java11-22.0.0.2/bin/javac
/root/jvm/graal-jdk11/graalvm-ce-java11-22.0.0.2/bin/java
```

###### Insert data:

```mysql
insert into Table_Testbed(id, Testbed_name, Testbed_version, Testbed_location) values(1,"HotSpot-jdk8","8.0.332","/root/jvm/openjdk8/jdk8u322-b04/build/linux-x86_64-normal-server-release/jdk/bin/java");
insert into Table_Testbed(id, Testbed_name, Testbed_version, Testbed_location)  values(2,"HotSpot-jdk11","11.0.14","/root/jvm/openjdk11/jdk-11.0.14-ga/build/linux-x86_64-normal-server-release/images/jdk/bin/java");

insert into Table_Testbed(id, Testbed_name, Testbed_version, Testbed_location)  values(3,"Openj9-jdk8","301202f","/root/jvm/openj9-jdk8/openj9-openjdk-jdk8/build/linux-x86_64-normal-server-release/images/j2sdk-image/bin/java");
insert into Table_Testbed(id, Testbed_name, Testbed_version, Testbed_location)  values(4,"Openj9-jdk11","24e7209","/root/jvm/openj9-jdk11/openj9-openjdk-jdk11/build/linux-x86_64-normal-server-release/images/jdk/bin/java");

insert into Table_Testbed(id, Testbed_name, Testbed_version, Testbed_location)  values("5","Zulu-jdk8","8.60.0.21","/root/jvm/zulu-jdk8/zulu8.60.0.21-ca-jdk8.0.322-linux_x64/bin/java");
insert into Table_Testbed(id, Testbed_name, Testbed_version, Testbed_location)  values(6,"Zulu-jdk11","11.54.25","/root/jvm/zulu-jdk11/zulu11.54.25-ca-jdk11.0.14.1-linux_x64/bin/java");

insert into Table_Testbed(id, Testbed_name, Testbed_version, Testbed_location)  values(7,"Kona-jdk8","8.0.8-GA","/root/jvm/kona-jdk8/TencentKona-8.0.8-312/bin/java");
insert into Table_Testbed(id, Testbed_name, Testbed_version, Testbed_location)  values(8,"Kona-jdk11","11.0.13-GA","/root/jvm/kona-jdk11/TencentKona-11.0.13.b1/bin/java");

insert into Table_Testbed(id, Testbed_name, Testbed_version, Testbed_location)  values(9,"GraalVM-jdk11","22.0.0.2","/root/jvm/graal-jdk11/graalvm-ce-java11-22.0.0.2/bin/java");

UPDATE Table_Testbed SET Testbed_version='8.0.9-GA',Testbed_location='/root/jvm/kona-jdk8/TencentKona-8.0.9-322/bin/java' WHERE id=7;
UPDATE Table_Testbed SET Testbed_version='11.0.14-GA',Testbed_location='/root/jvm/kona-jdk11/TencentKona-11.0.14.b1/bin/java' WHERE id=8;
```