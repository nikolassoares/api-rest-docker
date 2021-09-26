FROM maven:3.8.2-jdk-8 as build

WORKDIR /api-rest-docker
COPY . .
RUN mvn package -Dmaven.test.skip

CMD mvn spring-boot:run