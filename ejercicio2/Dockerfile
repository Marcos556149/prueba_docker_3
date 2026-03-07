# ---------- Build stage ----------
FROM maven:3.9.9-eclipse-temurin-17 AS build

WORKDIR /app

# Copiamos todo el proyecto
COPY . .

# Compilamos el proyecto y generamos el jar
RUN mvn clean package -DskipTests


# ---------- Runtime stage ----------
FROM eclipse-temurin:17-jdk-jammy

WORKDIR /app

# Copiamos el jar generado en la etapa anterior
COPY --from=build /app/target/*.jar app_ejercicio2.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","app_ejercicio2.jar"]