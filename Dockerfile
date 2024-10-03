FROM openjdk:21-jdk-slim
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
EXPOSE 10000
ENTRYPOINT ["java","-jar","/app.jar"]