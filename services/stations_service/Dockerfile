FROM openjdk:17-jdk-alpine3.14
EXPOSE 8080
ARG JAR_FILE=target/stations-service-1.0.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]