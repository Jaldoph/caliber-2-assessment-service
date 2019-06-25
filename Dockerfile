FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
ARG SPRING_ENV
EXPOSE 10003
ENV spring_profiles_active=$SPRING_ENV
COPY target/${JAR_FILE} app.jar
COPY pom.xml pom.xml
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/urandom -jar /app.jar" ]