# Dockerfile

FROM openjdk:11-jre-slim

WORKDIR /app

# file assembly
COPY target/scala-2.13/todo-api-assembly-0.1.jar ./app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
