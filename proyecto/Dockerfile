FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/proyecto-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app_proyecto.jar
EXPOSE 8090
ENTRYPOINT ["java","-jar","app_proyecto.jar"]

