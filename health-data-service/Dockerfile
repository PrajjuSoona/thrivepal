# Use an official JDK base image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /thrivepal

# Copy the target JAR file to the container and rename it
COPY target/health-data-service-1.0.0.jar app.jar

# Expose the application's port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
