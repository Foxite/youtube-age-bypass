FROM gradle:7.4-jdk17-alpine AS build
EXPOSE 8080

WORKDIR /src
COPY . .
RUN chown -R gradle:gradle . # Maybe there's a better way, idk.

USER gradle
RUN gradle bootJar # && gradle test

CMD ["gradle", "bootRun"]

FROM maven:3-openjdk-17 AS run
WORKDIR /app/

COPY --from=build /src/build/libs/spring-boot-0.0.1-SNAPSHOT.jar /app/app.jar

CMD ["java", "-jar", "app.jar"]
