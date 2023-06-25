FROM ubuntu:latest AS build
RUN apt-get update
RUN apt-get install openjdk-17-jdk -y
COPY . .
RUN ./mvn package -Dmaven.daemon.disable=true

FROM openjdk:17-slim
EXPOSE 8080

COPY --from=build /target/AutoSchool-1.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]