FROM openjdk:17-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} deneme.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/deneme.jar"]