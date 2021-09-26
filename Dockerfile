FROM maven:3.8.2-jdk-8 as build-spring

WORKDIR /api-rest-docker
COPY . .
RUN mvn clean install

CMD mvn spring-boot:run