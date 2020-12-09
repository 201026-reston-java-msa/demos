
# Week 7: Web & MicroServices

## Web Services
A **web service** is a collection of open protocols and standards used for exchanging data between applications or systems.<br>
A **web service** is any service that:
- Is available over the Internet
- Uses a standardized XML messaging system
- Is not tied to any one operating system or programming language
- Is self-describing via a common XML grammar
- Is discoverable via a simple find mechanism

## What is a RESTful Web Service?
A RESTful Web Service is a lightweight, maintainable, and scalable service that is built on the REST architecture.
* A RESTful Web Service will expose an API from your application in a secure, uniform, stateless manner to the calling client. 
* The calling client can perform predefined operations using the RESTful service. 
* The underlying protocol for REST is HTTP.

## What is REST?
* REST stands for **RE**presentational **S**tate **T**ransfer.
* REST is a way to access resources which lie in a particular environment.
* [Overview of REST](https://restfulapi.net/rest-architectural-constraints/)

>  For example, you could have a server that could be hosting important documents or pictures or videos. All of these are an example of resources. If a client, say a web browser needs any of these resources, it has to send a request to the server to access these resources. Now REST services defines a way on how these resources can be accessed.

### 6 REST Constraints (*know these and google what they mean!*)
There are six architectural constraints which makes any web service are listed below:
1. Uniform Interface
2. Stateless
3. Cacheable
4. Client-Server
5. Layered System
6. Code on Demand (optional)

## What is SOAP?
- Simple Object Access Protocol
- XML-based web service protocol
- Legacy protocol: most companies switching to RESTful web services
- Can be used in conjunction with any transport-layer protocol (HTTP, SMTP, FTP, etc)
  - When used with HTTP, POST requests are used
- Uses a contract (WSDL)
  - WSDL = Web service description language
  - Contract first vs contract last development
- Built-in security
- SOAP message elements
  - envelope
  - header
  - body
  - fault
  
  # Microservices
Microservices - also known as the microservice architecture - is an architectural style that structures an application as a collection of services that are. Highly maintainable and testable. Loosely coupled. Independently deployable. Organized around business capabilities.

