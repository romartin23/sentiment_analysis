FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD sentiment_analysis-0.1.1.jar app.jar
RUN sh -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
CMD ["PATH"]