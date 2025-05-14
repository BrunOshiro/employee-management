FROM azul/zulu-openjdk:17

WORKDIR /app

COPY target/*.jar /app/app.jar

EXPOSE 8080
EXPOSE 8081
