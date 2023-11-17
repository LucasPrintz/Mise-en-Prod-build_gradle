FROM openjdk:17-jdk-slim AS build
COPY /covid-api /var/www/covid-api
WORKDIR /var/www/covid-api
RUN ./gradlew clean build

FROM eclipse-temurin:17-jre-alpine
COPY --from=build /var/www/covid-api/build/libs/covid-api-0.0.1-SNAPSHOT.jar /var/www/covid-api.jar
EXPOSE 8080
CMD ["java", "-jar", "/var/www/covid-api.jar"]