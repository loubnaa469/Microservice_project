FROM openjdk:25-jdk-bullseye
WORKDIR /app
COPY Transaction_Service/target/Transaction-service.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
