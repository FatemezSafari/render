FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY . .
RUN chmod +x mvnw
RUN ./mvnw clean install -DskipTests
EXPOSE 8080
CMD ["java", "-jar", "target/Aura-0.0.1-SNAPSHOT.jar"]