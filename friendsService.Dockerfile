FROM maven:3.6.1-jdk-8-alpine AS buildstage
WORKDIR /friendsservice
COPY friendsservice/ .
RUN mvn package -DskipTests

FROM openjdk:8-jre-alpine3.9
WORKDIR /friendsserviceapp
COPY --from=buildstage /friendsservice/target/friendsservice-0.0.1-SNAPSHOT.jar .
EXPOSE 8080
CMD java -jar friendsservice-0.0.1-SNAPSHOT.jar
