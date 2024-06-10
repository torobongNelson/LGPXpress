FROM maven:3.9.5-openjdk-21 as build
COPY . .
RUN mvn clean package-DskipTests


FROM openjdk:21-jdk-slim
COPY --from=build /target/demo-0.0.1-SNAPSHOT.jar demo.jar