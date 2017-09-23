FROM openjdk:jre
ADD target/logprocessing.jar ./
CMD ["java","-jar","logprocessing.jar"]
