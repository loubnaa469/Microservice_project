FROM openjdk:25-jdk-bullseye
WORKDIR /app
COPY Client_Service/target/Client_Service-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
