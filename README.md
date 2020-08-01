# Payment Gateway Demo

This is a demo project for the coding test.
- Tech Stack
    - Spring Boot
    - Swagger - documenting the API
    - Lombok 
    - FastXML/jackson - Json library for response
    - Junit5
- It is a Restful web service
- Github: https://github.com/natezhengbne/payment_gateway_demo.git

## Table of Contents

- [Structure](#Structure)
- [Build](#Build)
- [Usage](#usage)

## Structure
```
payment_gateway_demo
├── module-core  -- service
├── module-web   -- rest 
```

## Build

If you use Maven, run the following command in a terminal window (in the /payment_gateway_demo) directory:

```
./mvnw clean package
```

The web configuration in payment_gateway_demo/module-web/src/main/resources/application.properties file


## Usage

```
java -jar ./module-web/target/payment_gateway_web.jar
```

visit http://localhost:8080/api/swagger-ui.html after starting the application



