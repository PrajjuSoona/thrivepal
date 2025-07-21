# Use an official JDK image
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /thrivepal

# Copy the built fat JAR
COPY target/user-service-1.0.0.jar app.jar

# Expose the application port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
