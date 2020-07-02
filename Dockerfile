FROM openjdk:11.0-jre
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=build/libs/jpabase-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} jpabase.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/jpabase.jar"]
