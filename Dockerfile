FROM openjdk:jre
ADD target/logprocessing.jar ./
CMD ["run.sh"] 
