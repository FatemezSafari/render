FROM eclipse-temurin:17-jdk-alpine as builder

WORKDIR /app

# Copy only what's needed for build
COPY pom.xml .
COPY src ./src
COPY mvnw .
COPY .mvn .mvn

# Make mvnw executable and build the project
RUN chmod +x mvnw
RUN ./mvnw clean package -DskipTests

# Create a new stage for runtime
FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

# Copy the built JAR from the builder stage
COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]