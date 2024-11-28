FROM openjdk:17-jdk-alpine

VOLUME /tmp
WORKDIR /app

COPY target/*.jar /app/app.jar
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
