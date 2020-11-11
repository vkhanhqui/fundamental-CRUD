FROM openjdk:8
VOLUME /tmp
ADD target/simple-demo.jar app.jar
ENTRYPOINT exec java -jar app.jar