# Base image to use, this must be set as the first line
FROM ubuntu:22.04
ENV DEBIAN_FRONTEND noninteractive
ENV LANG C.UTF-8
LABEL image.name="asmfuzz"

WORKDIR /root

ENV http_proxy="http://10.15.22.105:7890"
ENV https_proxy="http://10.15.22.105:7890"

RUN apt-get update && apt-get install -y \
    curl bzip2 openssh-server curl zip vim \
    && rm -rf /var/lib/apt/lists/*
COPY ./asmfuzz/env/Miniconda3-latest-Linux-x86_64.sh /root
RUN chmod +x /root/Miniconda3-latest-Linux-x86_64.sh
RUN /root/Miniconda3-latest-Linux-x86_64.sh -b -p /root/miniconda3/

WORKDIR /root/miniconda3/envs
RUN mkdir asmfuzz

COPY ./asmfuzz/env/asmfuzz-0.0-py31_0.tar.bz2 /root/miniconda3/envs/asmfuzz/

RUN mkdir /var/run/sshd  \
    && echo 'root:issre2024' | chpasswd  \
    && echo "PasswordAuthentication yes" >> /etc/ssh/sshd_config  \
    && echo "PermitRootLogin yes" >> /etc/ssh/sshd_config \
    && echo "Port 10349" >> /etc/ssh/sshd_config \
    && echo "service ssh restart" >> ~/.bashrc \
    && echo 'export PATH="/root/miniconda3/bin:$PATH"' >> ~/.bashrc

ENV http_proxy=""
ENV https_proxy=""