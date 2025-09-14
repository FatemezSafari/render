# Use a compatible Java 17 base image
FROM eclipse-temurin:17-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the Maven wrapper and pom.xml first (for better layer caching)
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Copy the source code
COPY src src

# Make the mvnw script executable
RUN chmod +x mvnw

# Build the application
RUN ./mvnw clean install -DskipTests

# Expose the port your app runs on
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "target/*.jar"]