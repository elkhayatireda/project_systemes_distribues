# E-Bank Microservices

**By Reda EL KHAYATI**

A Spring Boot and Spring Cloud project for managing customers and bank accounts through a microservices architecture.

## Services

- **Customer-Service** — customer management and REST API
- **EBank-Service** — bank account management; gets customer details through OpenFeign
- **Discovery Service** — service registry using Eureka
- **Gateway** — entry point for requests and dynamic service routing

The EBank-Service includes fault tolerance with a Resilience4J circuit breaker.

## Technologies

Java 21, Spring Boot, Spring Cloud, Spring Data JPA, OpenFeign, Eureka, Spring Cloud Gateway, Resilience4J, Swagger UI, Maven.

## Starting the services

Start the services in this order:

1. Discovery Service
2. Customer-Service
3. EBank-Service, after Customer-Service appears in Eureka
4. Gateway

## Screenshots

### Customer-Service

![Customer-Service API test](images/img.png)
![Customer-Service API test](images/img_1.png)
![Customer-Service API test](images/img_2.png)

### EBank-Service

![EBank-Service API test](images/img_3.png)
![EBank-Service API test](images/img_4.png)
![EBank-Service API test](images/img_5.png)

### Gateway and Discovery

![Static gateway routing](images/img_6.png)
![Static gateway routing result](images/img_7.png)
![Discovery Service dynamic routing](images/img_8.png)

### OpenFeign and circuit breaker

![OpenFeign customer lookup](images/img_9.png)
![OpenFeign result](images/img_10.png)
![Circuit breaker fallback](images/img_11.png)
