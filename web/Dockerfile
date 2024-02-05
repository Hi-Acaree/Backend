## Use the official OpenJDK base image for a Java runtime
#FROM openjdk:19-jdk-slim as builder
#
## Set the working directory inside the container
#WORKDIR /app
#
## Copy the WAR file into the image
#COPY target/web.war ./
#
## Use the Spring Boot Maven plugin to unpack the WAR
#RUN java -Djarmode=layertools -jar web.war extract
#
## Start with a new image to create a clean final image
#FROM openjdk:19-jdk-slim
#
## Set the working directory inside the container
#WORKDIR /app
#
## Copy the unpacked layers from the builder stage
#COPY --from=builder /app/dependencies/ ./
#COPY --from=builder /app/spring-boot-loader/ ./
#COPY --from=builder /app/snapshot-dependencies/ ./
#COPY --from=builder /app/application/ ./
#
## Specify the entry point to run the application
#ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]

# Use the official OpenJDK base image for a Java runtime
FROM openjdk:19-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the WAR file into the image
COPY target/web.war .

# Specify the entry point to run the application
ENTRYPOINT ["java", "-jar", "web.war"]

