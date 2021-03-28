FROM maven:3.5.2-jdk-8-alpine AS MAVEN_BUILD

MAINTAINER Brian Hannaway

COPY pom.xml /build/
COPY src /build/src/

WORKDIR /build/
RUN mvn package

FROM openjdk:14-alpine

WORKDIR /app

COPY  --from=MAVEN_BUILD /build/target/weWurx*.jar /app/


CMD ["java" , "-jar" , "/weWurx*.jar"]