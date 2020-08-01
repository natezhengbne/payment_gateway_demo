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
- [Improvement](#Improvement)

## Structure
``` lua
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


## Improvement

The validator can be employed a class-level custom annotation, so the payment business logic will not depend on the validation.

``` java
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CreditCardNumberValidator {
    String cardNumber();
	String cardType();
}
```

Now Spring AOP will intercept the request and validate the credit card number before the payment method is invoked
``` java
import org.aspectj.lang.annotation.Before;

@Before(value = "@annotation(creditCardNumberValidator)", 
    argNames = "jp,c reditCardNumberValidator")
public void creditCardNumberValidator(JoinPoint jp, CreditCardNumberValidator validtor){
    // get cardType & cardNum from annoation parameters or HttpServletRequest
    Boolean isValid = creditCardValidatorFactory.get(cardType).validate(cardNum);
    if(!isValid){
        throw new RuntimeException("Credit Card is invalid.");
    }
}
```
