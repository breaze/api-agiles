FROM amazoncorretto:25-alpine
WORKDIR /app
COPY mvnw pom.xml ./
COPY .mvn .mvn
RUN chmod +x mvnw && ./mvnw dependency:go-offline
COPY src src
RUN ./mvnw package -DskipTests
EXPOSE 8080
CMD ["java", "-jar", "target/estudiantes-agiles-0.0.1-SNAPSHOT.jar"]