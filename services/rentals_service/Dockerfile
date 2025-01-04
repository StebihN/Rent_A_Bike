FROM openjdk:17-jdk-alpine3.14
EXPOSE 8081
ARG JAR_FILE=target/rentals_service-1.0.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]