# Build stage with Maven and OpenJDK
FROM maven:3.8.7-eclipse-temurin-19 as build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Run stage with OpenJDK
FROM eclipse-temurin:19-jdk
COPY --from=build /app/web/target/web.war /app/web.war
WORKDIR /app
CMD ["java", "-jar", "web.war"]
