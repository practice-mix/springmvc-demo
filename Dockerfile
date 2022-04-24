FROM openjdk:8-jre-alpine
RUN mkdir -p /app

# Copy app artifact
COPY ./target/*.jar /app/app.jar

# Copy Thundra bootstrap agent artifact.
# Please rename with the file you have downloaded at the first step.
#COPY "D:\PortableSoft\thundra-agent-bootstrap-2.7.22.jar" /app/

WORKDIR /app
EXPOSE 8080
#ENTRYPOINT [ "java", "-javaagent:thundra-agent-bootstrap.jar", "-jar", "mvc-demo-2.1.2.RELEASE.jar" ]
ENTRYPOINT [ "java",  "-jar", "app.jar" ]

