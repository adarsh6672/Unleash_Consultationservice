FROM openjdk:17-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ./target/consultation-service.jar consultation-service.jar

ENV MYSQL_HOST=unleashDb
ENV MYSQL_PORT=3306
ENV MYSQL_DB_NAME=consultationservice_db
ENV MYSQL_USER=user
ENV MYSQL_PASSWORD=MYSQL_ROOT_PASSWORD


ENTRYPOINT ["java","-jar","/consultation-service.jar"]