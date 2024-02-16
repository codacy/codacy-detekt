FROM sbtscala/scala-sbt:eclipse-temurin-jammy-11.0.22_7_1.9.8_2.13.12 as builder
WORKDIR /app
COPY project project
COPY build.sbt build.sbt
COPY src src
RUN sbt stage

FROM amazoncorretto:11-alpine3.19
RUN apk add bash
WORKDIR /opt/docker
COPY docs /docs
COPY --from=builder /app/target/universal/stage/ ./
RUN adduser -u 2004 -D docker && chmod +x /opt/docker/bin/engine
USER docker
ENTRYPOINT ["/opt/docker/bin/engine"]
