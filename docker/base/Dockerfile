FROM openjdk:8-jre-alpine

ENV SCALA_VERSION=2.13.10 \
    SCALA_HOME=/usr/share/scala

RUN apk add --no-cache --virtual=.build-dependencies wget ca-certificates \
    && apk add --no-cache bash curl jq \
    && cd "/tmp" \
    && wget --no-verbose "https://downloads.typesafe.com/scala/${SCALA_VERSION}/scala-${SCALA_VERSION}.tgz" \
    && tar xzf "scala-${SCALA_VERSION}.tgz" \
    && mkdir "${SCALA_HOME}" \
    && rm "/tmp/scala-${SCALA_VERSION}/bin/"*.bat  \
    && mv "/tmp/scala-${SCALA_VERSION}/bin" "/tmp/scala-${SCALA_VERSION}/lib" "${SCALA_HOME}" \
    && ln -s "${SCALA_HOME}/bin/"* "/usr/bin/" \
    && apk del .build-dependencies \
    && rm -rf "/tmp/"

WORKDIR /root

COPY ../../target/scala-2.13/githubapi-sink-assembly-0.1.0-SNAPSHOT.jar /root/github-sink.jar

RUN mkdir docker

COPY ./docker docker

CMD scala github-sink.jar user -u himewel