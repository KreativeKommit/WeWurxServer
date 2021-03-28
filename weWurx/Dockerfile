FROM maven:3.6.3-jdk-11-slim AS MAVEN_BUILD

COPY pom.xml /build/
COPY src /build/src/

WORKDIR /build/
RUN mvn -f /build/pom.xml clean install

FROM openjdk:11-jre-slim

WORKDIR /app

COPY  --from=MAVEN_BUILD /build/target/weWurx*.jar /app/demo.jar


CMD ["java" , "-jar" , "/app/demo.jar"]