FROM openjdk:8-jre-alpine
RUN mkdir -p /app

# Copy app artifact
ADD target/mvc-demo-2.1.2.RELEASE.jar /app/mvc-demo-2.1.2.RELEASE.jar

# Copy Thundra bootstrap agent artifact.
# Please rename with the file you have downloaded at the first step.
#ADD "D:\PortableSoft\thundra-agent-bootstrap-2.7.22.jar" /app/thundra-agent-bootstrap.jar

WORKDIR /app
EXPOSE 8080
#ENTRYPOINT [ "java", "-javaagent:thundra-agent-bootstrap.jar", "-jar", "mvc-demo-2.1.2.RELEASE.jar" ]
ENTRYPOINT [ "java",  "-jar", "mvc-demo-2.1.2.RELEASE.jar" ]

