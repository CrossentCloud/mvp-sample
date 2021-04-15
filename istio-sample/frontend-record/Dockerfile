ARG MAVEN_VERSION=3.6.1-jdk-11-slim
ARG JDK_VERSION=8-jre-alpine
ARG MAINTAINER=heunji@clap.com

#=========================================================#
# Builder #
#=========================================================#
FROM maven:$MAVEN_VERSION AS MAVEN_BUILD

COPY pom.xml /build/

COPY settings.xml /root/.m2/

COPY src /build/src/

WORKDIR /build/

RUN mvn package -s /root/.m2/settings.xml -DskipTests=true

#=========================================================#
# Runtime #
#=========================================================#
FROM openjdk:$JDK_VERSION

WORKDIR /app

COPY --from=MAVEN_BUILD /build/target/*.jar /app/app.jar

ENTRYPOINT ["sh", "-c"]
CMD ["exec java -Djava.net.preferIPv4Stack=true -Djava.security.egd=file:/dev/./urandom -Dspring.profiles.active=dev -jar app.jar"]
