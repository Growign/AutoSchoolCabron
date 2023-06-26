FROM ubuntu:latest AS build
RUN apt-get update
RUN apt-get install openjdk-17-jdk -y
RUN apt-get install maven -y

COPY . .
RUN mvn clean install

FROM openjdk:17-slim
EXPOSE 8080

COPY --from=build /target/AutoSchool-1.jar app.jar

ENTRYPOINT ["mvn", "spring-boot:run"]
