FROM bde2020/hadoop-maven-template:1.2.1-hadoop2.8-java8

MAINTAINER Gezim Sejdiu <g.sejdiu@gmail.com>

ENV JAR_FILEPATH="hadoop-starter-0.0.1-SNAPSHOT-with-dependencies.jar"
ENV JAR_NAME="hadoop-starter-0.0.1-SNAPSHOT-with-dependencies"
ENV CLASS_TO_RUN="tech.sda.starter.hadoop.WordCount"
ENV PARAMS="/opt/hadoop-2.8.0/README.txt /opt/hadoop-2.8.0/wordcounttest"
