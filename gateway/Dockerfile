FROM openjdk:25-jdk-bullseye
WORKDIR /app
COPY gateway/target/api-gateway-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]