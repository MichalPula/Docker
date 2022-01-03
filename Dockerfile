FROM openjdk:11
ADD target/drake_api.jar .
ENTRYPOINT ["java", "-jar", "drake_api.jar"]

#Image-tag : drake-rest-api-image
