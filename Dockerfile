FROM bde2020/hadoop-maven-template:1.2.1-hadoop2.8-java8

MAINTAINER Gezim Sejdiu <g.sejdiu@gmail.com>

ENV JAR_FILEPATH="mvn-hadoop-1.0-SNAPSHOT-with-dependencies.jar"
ENV JAR_NAME="mvn-hadoop-1.0-SNAPSHOT-with-dependencies"
ENV CLASS_TO_RUN="ir.phsys.WordCountSc"
ENV PARAMS="/opt/hadoop-2.8.0/README.txt /opt/hadoop-2.8.0/wordcounttest"
