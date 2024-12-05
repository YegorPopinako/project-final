FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/jira-1.0.jar app.jar

EXPOSE 8080

ENTRYPOINT ["sh", "-c", "java -jar app.jar"]
