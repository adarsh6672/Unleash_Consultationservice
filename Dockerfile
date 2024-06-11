FROM openjdk:17-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ./target/consultation-service.jar consultation-service.jar

ARG MYSQL_HOST
ARG MYSQL_PORT
ARG MYSQL_USER
ARG MYSQL_PASSWORD

ENV KAFKA_BOOTSTRAP_SERVERS = kafka
ENV EUREKA_HOST=discovery-service
ENV MYSQL_HOST=${MYSQL_HOST}
ENV MYSQL_PORT=${MYSQL_PORT}
ENV MYSQL_USER=${MYSQL_USER}
ENV MYSQL_PASSWORD=${MYSQL_PASSWORD}


ENTRYPOINT ["java","-jar","/consultation-service.jar"]