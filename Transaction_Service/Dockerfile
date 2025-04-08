FROM openjdk:25-jdk-bullseye
WORKDIR /app
COPY Transaction_Service/Transaction_Service/target/Transaction-service.jar.original app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
