# ASMFuzz

For the paper reproduction, we provide three reproduction methods, 
*jupyter notebook*, *docker compose* to build containers, and the full version of the *docker container* into the system.

## Artifact Evaluation (AE)

### 1. jupyter notebook (recommend ️❤️)
> We provide an interactive Jupyter Notebook hosted on a remote server.  
> The notebook first uses a single case to demonstrate the entire asmfuzz pipeline.  
> Then, it conducts small-scale testing and finally reproduces the evaluation presented in our paper. 

Online jupyter <www.asmfuzz.cn>

Password:issre2024

There are detailed implementation steps in the document AE.ipynb

> AE Closed, link closed, contact f335125303@163.com if you need help #

> If you reproduce it in jupyter, you can omit all the following environment configuration steps.

### 2. docker compose (About 15min for environment configuration)

> Requires the host to have docker and docker-compose downloaded, and an open network.

```bash
git clone https://github.com/ASMFuzz/ASMFuzz.git
```

In the same directory as the dockerfile, execute the `docker-compose up -d`


### 3. docker container (About 30min for environment configuration)

> Download the latest version of the container and import docker  
> jvm https://zenodo.org/records/13370552   (10.5281/zenodo.13370552)  
> asmfuzz.tar: https://zenodo.org/records/13370849

```bash
docker import asmfuzz < asmfuzz.tar

cd /root/asmfuzz

unzip jvm.zip -d jvm/
```


## 2. Environmental requirements

### 2.1 JDK and Python

```
openjdk 11.0.23
Python 3.11.5
```
The jupyter notebook/docker container will include the environment automatically, if you want to configure it by yourself, see the detailed procedure [Environment Initialization](asmfuzz/docs/Environment-Initialization.md).


### 2.2 Activating the conda environment

```bash
conda activate asmfuzz
```

### 2.3 Access to the working directory
```bash
cd  /root/asmfuzz/  ## [path]/ASMFuzz
git pull
```

### 2.4 Database Initialization

```bash
cd /root/asmfuzz/workline/web/
python manage.py loaddata analysis/fixtures/testbed.json
```

###  二、Generate seeds

2.1  Using the `step0_preprocess.py` script to generate the seeds.

```bash
cd /root/asmfuzz/workline/
python /root/asmfuzz/workline/step0_generate_seed.py --num_return_sequences=100 --total_iterations=2
```

> To ensure successful reproduction, make sure the host machine has an *Nvidia GPU* with the appropriate drivers installed. This will help control generation time within a reasonable range. (The program is also compatible with CPU generation, and these are automatically recognized without the need for separate configuration.)

### 三、 Synthesizing Test Cases

3.1 Synthesizing Test Cases
Run it directly from maven (Recommend)

```
cd /root/asmfuzz/parser/feature
mvn clean install -DskipTests
java -jar /root/asmfuzz/parser/feature/target/InsertMain-1.0-shaded.jar org.example.InsertMain
```


OR 
```bash
/root/.jdks/corretto-11.0.21/bin/java -Dfile.encoding=UTF-8 -classpath /home/mysql-connector-java-8.0.28.jar:/root/asmfuzz/parser/feature/target/classes:/root/.m2/repository/com/fasterxml/jackson/dataformat/jackson-dataformat-yaml/2.12.4/jackson-dataformat-yaml-2.12.4.jar:/root/.m2/repository/com/fasterxml/jackson/core/jackson-databind/2.12.4/jackson-databind-2.12.4.jar:/root/.m2/repository/com/fasterxml/jackson/core/jackson-annotations/2.12.4/jackson-annotations-2.12.4.jar:/root/.m2/repository/com/fasterxml/jackson/core/jackson-core/2.12.4/jackson-core-2.12.4.jar:/root/.m2/repository/org/yaml/snakeyaml/1.27/snakeyaml-1.27.jar:/root/.m2/repository/com/github/javaparser/javaparser-core-serialization/3.24.8/javaparser-core-serialization-3.24.8.jar:/root/.m2/repository/javax/json/javax.json-api/1.1.4/javax.json-api-1.1.4.jar:/root/.m2/repository/com/github/javaparser/javaparser-core/3.24.8/javaparser-core-3.24.8.jar:/root/.m2/repository/com/github/javaparser/javaparser-core-generators/3.24.8/javaparser-core-generators-3.24.8.jar:/root/.m2/repository/com/github/javaparser/javaparser-symbol-solver-core/3.24.8/javaparser-symbol-solver-core-3.24.8.jar:/root/.m2/repository/org/javassist/javassist/3.29.2-GA/javassist-3.29.2-GA.jar:/root/.m2/repository/com/google/guava/guava/31.1-jre/guava-31.1-jre.jar:/root/.m2/repository/com/google/guava/failureaccess/1.0.1/failureaccess-1.0.1.jar:/root/.m2/repository/com/google/guava/listenablefuture/9999.0-empty-to-avoid-conflict-with-guava/listenablefuture-9999.0-empty-to-avoid-conflict-with-guava.jar:/root/.m2/repository/com/google/code/findbugs/jsr305/3.0.2/jsr305-3.0.2.jar:/root/.m2/repository/org/checkerframework/checker-qual/3.12.0/checker-qual-3.12.0.jar:/root/.m2/repository/com/google/errorprone/error_prone_annotations/2.11.0/error_prone_annotations-2.11.0.jar:/root/.m2/repository/com/google/j2objc/j2objc-annotations/1.3/j2objc-annotations-1.3.jar:/root/.m2/repository/com/github/javaparser/javaparser-symbol-solver-logic/3.15.15/javaparser-symbol-solver-logic-3.15.15.jar:/root/.m2/repository/com/github/javaparser/javaparser-symbol-solver-model/3.15.15/javaparser-symbol-solver-model-3.15.15.jar:/root/.m2/repository/cn/hutool/hutool-all/5.8.11/hutool-all-5.8.11.jar:/root/.m2/repository/dom4j/dom4j/1.1/dom4j-1.1.jar:/root/.m2/repository/org/apache/commons/commons-lang3/3.12.0/commons-lang3-3.12.0.jar:/root/.m2/repository/mysql/mysql-connector-java/8.0.30/mysql-connector-java-8.0.30.jar:/root/.m2/repository/com/google/protobuf/protobuf-java/3.19.4/protobuf-java-3.19.4.jar:/root/.m2/repository/org/slf4j/slf4j-api/1.7.36/slf4j-api-1.7.36.jar org.example.InsertMain
```

### 三、 Differential Fuzzing

3.1 Differential Fuzzing
```bash
cd /root/asmfuzz/workline
python /root/asmfuzz/workline/step3_harness.py
```
---------------
