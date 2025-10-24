# Stage 1: Build
FROM maven:3.9.2-eclipse-temurin-17 AS build
WORKDIR /app
# Copy the whole project folder into the image
COPY todo-backend/ ./todo-backend/
WORKDIR /app/todo-backend
# Build the project
RUN mvn clean package -DskipTests

# Stage 2: Run
FROM openjdk:17
WORKDIR /app
# Copy the built JAR from the build stage
COPY --from=build /app/todo-backend/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
