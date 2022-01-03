FROM openjdk:11
EXPOSE 8083
ADD target/kanye_vs_drake_frontend.jar .
ENTRYPOINT ["java", "-jar", "kanye_vs_drake_frontend.jar"]
