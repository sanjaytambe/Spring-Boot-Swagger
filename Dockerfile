From openjdk:8
copy ./target/SwaggerApplication-0.0.1-SNAPSHOT.jar SwaggerApplication-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","SwaggerApplication-0.0.1-SNAPSHOT.jar"]