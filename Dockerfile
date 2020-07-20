FROM openjdk:8-jre-alpine
RUN apk add bash
WORKDIR /opt/docker
COPY docs /docs
COPY target/universal/stage/ ./
RUN adduser -u 2004 -D docker && chmod +x /opt/docker/bin/engine
USER docker
ENTRYPOINT ["/opt/docker/bin/engine"]
