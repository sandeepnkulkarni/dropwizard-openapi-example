# Dropwizard OpenAPI Example

Created using dropwizard-archetype with below command:

`mvn archetype:generate -DarchetypeGroupId=io.dropwizard.archetypes -DarchetypeArtifactId=java-simple -DarchetypeVersion=2.0.28`

More information: https://www.dropwizard.io/en/latest/getting-started.html

How to start the HelloWorld application
---

1. Run `mvn clean package` to build your application
1. In case you want to modify ports, update those in `helloworld.yml`
1. Start application with `java -jar target/dropwizard-openapi-example-1.0-SNAPSHOT.jar server helloworld.yml`
1. To check that your application is running enter url `http://localhost:8080`

Health Check
---

To see your applications health enter url `http://localhost:8081/healthcheck`

Custom POM file
---
Used reference from here: https://github.com/dropwizard/dropwizard/blob/v2.0.28/dropwizard-example/pom.xml

OpenAPI Specification
---
Available at: http://localhost:8080/api/openapi.json

Swagger UI
---
Available at: http://localhost:8080/

Reference
---
Started first by following steps mentioned in blog post: https://niftysoft.github.io/devlog/2018/05/03/open-api-v3.html

Then used sample code available at https://github.com/swagger-api/swagger-samples/tree/2.0/java/java-dropwizard to add Swagger UI.