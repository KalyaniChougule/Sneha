FROM java:8
VOLUME /tmp
ADD sampleatommicroservice-V1.0.jar ////app.jar
RUN bash -c 'touch /app.jar'
EXPOSE 9081
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]