FROM openjdk:11
ADD target/kanye_api.jar .
ENTRYPOINT ["java", "-jar", "kanye_api.jar"]

#Image-tag : kanye-rest-api-image
