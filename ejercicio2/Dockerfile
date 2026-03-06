FROM eclipse-temurin:17-jdk-jammy
ARG JAR_FILE=target/ejercicio2-0.0.1.jar
COPY ${JAR_FILE} app_ejercicio2.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app_ejercicio2.jar"]