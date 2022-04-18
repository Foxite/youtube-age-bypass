FROM gradle:7.4-jdk17-alpine AS base
EXPOSE 8080

WORKDIR /src
COPY . .
RUN chown -R gradle:gradle . # Maybe there's a better way, idk.

USER gradle
RUN gradle classes && gradle test

CMD ["gradle", "bootRun"]
