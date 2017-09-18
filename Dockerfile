FROM openjdk:jre
ADD target/springcassandra.jar ./
ENTRYPOINT ["java","-jar","springcassandra.jar"]