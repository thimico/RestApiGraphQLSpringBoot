FROM maven:3.5-jdk-8 as build

# image layer
WORKDIR /app
COPY pom.xml .

RUN mvn dependency:go-offline

COPY src src
RUN mvn package -DskipTests
#RUN mvn clean install -DskipTests

# Image layer: with the application
FROM openjdk:8u171-jre-alpine
LABEL "MAINTAINER"="Thiago Menezes <thg.mnzs@gmail.com | thimico@gmail.com>"
VOLUME /tmp
EXPOSE 8080
COPY --from=build /app/target/*.jar /developments/app.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/developments/app.jar"]