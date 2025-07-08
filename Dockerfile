# Stage 1: Build the application using Gradle
FROM gradle:7.5.1-jdk17 AS builder

# Set working directory inside container
WORKDIR /home/app

# Copy the entire project into the container
COPY . /home/app

# Run the Gradle build
RUN gradle build --no-daemon

# Stage 2: Create a smaller image to run the app
FROM openjdk:17

# Copy only the built JAR file from the builder stage
COPY --from=builder /home/app/build/libs/*.jar /app/app.jar

# Run the application
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
