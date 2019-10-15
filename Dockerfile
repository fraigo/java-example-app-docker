FROM maven:3.6.2-jdk-8

EXPOSE 5000

COPY ./ /home/src/ 

WORKDIR /home/src

CMD [ "java", "-jar",  "target/java-example-app-1.0.jar" ]