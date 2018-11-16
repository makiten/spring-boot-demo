FROM openjdk:8-jdk-alpine
WORKDIR /app
RUN apk update && \
    apk upgrade && \
    apk --no-cache add git
RUN git clone https://github.com/makiten/spring-boot-demo.git .
RUN ./gradlew build -x test && \
    java -jar build/libs/bootdemo-0.0.1-SNAPSHOT.jar

# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
FROM openjdk:8-jdk-alpine
RUN apk --no-cache add ca-certificates
VOLUME /tmp
WORKDIR /app
COPY --from=builder /app/build/libs/bootdemo-0.0.1-SNAPSHOT.jar /app/bootdemo.jar
ENV JAVA_OPTS=""
ENTRYPOINT [ "java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app/bootdemo.jar" ]
