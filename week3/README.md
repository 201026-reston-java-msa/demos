# Study Guide for QC on Monday Nov. 16th, 2020
*Remember that you will also have to refer to [Week 2's QC study guide](https://github.com/201026-reston-java-msa/demos/blob/main/week2/README.md) because you may be asked questions on SQL.*

> Keep In mind that we have covered a lot of info spanning across many different topics. QC questions will most likely be broken down into the following: <br>
> - 25% [SQL](https://github.com/201026-reston-java-msa/demos/blob/main/week2/README.md)
> - 10% HTML
> - 10% CSS
> - 25% Servlets
> - 15% HTTP & Client/Server Architecture
> - 15% JavaScript

### Topics Covered in Week 3:
* HTML
* CSS
* AWS S3 *just know what these are - nothing too in depth*
* Servlets
* JavaScript

## HTTP
- Hyper Text Transfer Protocol
- Primary networking protocol used for client-server communication
  - The internet (world-wide-web)
- This is also specifically used for RESTful web services
- For now, it's important to understand the differences between different
  HTTP verbs (methods), such as **GET** and **POST** as well as HTTP status codes
- All HTTP messages are composed of a header and a body which contains different
  pieces of information.. The header normally represents the metadata about the
  request. Whereas the body represents the data in the message, or the message itself.
- **GET vs POST**
  - **GET** is utilized to retrieve data. We're retrieving data from some url, or endpoint,
    and normally clients and servers are not expecting these messages to contain content
    within the body. (Although, you definitely still can)
  - **POST** is generally used to send/update information on the url/endpoint, which means
    that the server os expecting the message to have information in the body.
- HTTP responses have a status code that represent the status of the request. We'll talk
  more about them in a moment, but we have seen examples such as 200 OK, and 201 CREATED *see the **HTTP Status Codes** listed below***
- HTTP responses can also have a body. If a GET request was performed, generally,the response is stored in the body.

### HTTP Status Codes
- There are 5 different sets of status codes
  1. 1XX Series, informational messages
  2. 2XX Series, requests were successful
    - 200 OK
    - 201 CREATED
  3. 3XX, redirection
    - 301 Moved Permanently
    - 307 Temporary Redirect
  4. 4XX, Client-Side errors
    - 400 Bad Request
    - 401 Not Authorized
    - 403 Forbidden
    - 404 Not Found
    - 418 I'm a Teapot
  5. 5XX, Server-Side errors
    - 500 Internal Server Error
    - 501 Not Implemented
    - 502 Bad Gateway
    - 504 Gateway timeout

## Session Management
- The practice of storing information about the user in the server in order
  to improve user experience

**Why do sessions matter**?
- User Experience: Saving session information locally prevents
  needless hits to your database, which improves performance and allows you
  to personalize a user's experience.
- Security: Verify that a user actually has access to a resource that was
  provided by your website. Disallow access to sensitive information.

## Sending Users to different locations on the Web / Redirects
- Servlets take requests from clients and forward them to requested resources. How?
  - There are 2 ways:
    - `SendRedirect`
      - Supplied by Response object
      - This is a method: response.sendRedirect(location);
      - Actually send a response back to the client and then
        sends a new request back.
      - As a result, the information in the previous request is lost
      - Returns a 300 Series status code
    - `Forward`
      - Supplied by Request object
      - This method is declared on the RequestDispatcher Interface
      - When you use forward, the request never leaves the server
      - You can't request dispatch into another location (stay within same domain)
      - You make only 1 request, not 2

  - Main Takeaway:
    - Use sendRedirect when your client asks for a resource that is in some
      other location (the extra request is visible in the client as a new request)
    - Use forward if the your client is asking for a resource from the same
      project (something you have access to immediately)
    - Forward is handled by the server
    - sendRedirect is handled by the browser/client

## Servlet Config
- ServletConfig (interface) provides objects that are used by the Servlet
  containers (aka web container) to pass information to a servlet during
  initialization
  - getInitParameter()
  - getServletContext()
- Serializable interface is a marker interface (an empty interface) that can be
  implemented in order to allow an object to be "serialized" (to basically save
  to a file) and "deserialized".
  - In particular, if our Servlet classes implement Serializable, then we can serialize
    them to allow the servlet to "survive" restarting the web container.
- GenericServlet is an abstract class which supports any protocol, HTTP, UDP, TCP, etc
  - It is not necessarily designed for HTTP
- HttpServlet abstract class which allows you to create a servlet suitable
  for handling http requests.
  - doPOST, doGET, etc
  - Note, HttpServlet is an abstract class, so it is meant to be extended

## ServletConfig vs ServletContext

- The ServletConfig is unique to each individual servlet
  - No other servlet can access another's config
- The ServletContext is shared across all servlets

## Servlet QC Questions

1.  What is a servlet? What about a servlet container? Which servlet container have you worked with?
2.  Describe the servlet class inheritance hierarchy. What methods are declared in each class or interface?
3.  How would you create your own servlet?
4.  What is the deployment descriptor? What file configures your servlet container?   
5.  Explain the lifecycle of a servlet - what methods are called and when are they called?
6.  Is eager or lazy loading of servlets the default? How would you change this?
7.  What are some tags you would find in the web.xml file?
8.  What is the difference between the ServletConfig and ServletContext objects? How do you retrieve these in your servlet?
9.  What is the purpose of the RequestDispatcher?
10.  Explain the difference between RequestDispatcher.forward() and HttpServletResponse.sendRedirect()
11.  What are some different ways of tracking a session with servlets?
12.  What is object mapping? Any Java libraries for this?
13.  How would you send text or objects back in the body of the HTTP response from a servlet?
14.  What is the difference between getParameter() and getAttribute() methods?
15.  Explain the front controller design pattern

## Servlet Study Guide

- **Servlet Inheritance Hierarchy**
  - Servlet interface
  - GenericServlet abstract class
  - HttpServlet abstract class
- Servlet container
- Servlet lifecycle
- **Deployment descriptor**
  - What folder is it in?
  - web.xml tags
- Creating custom servlets
- Eager vs lazy loading / instantiation of servlets
- ServletConfig object
- ServletContext object
- RequestDispatcher
- Forwarding vs redirecting
- **Session tracking**
  - HttpSession API
  - Cookies
  - URL rewriting
  - HTML hidden fields
- Retrieving request parameters
- Retrieving data submitted from a form
- Sending a plain text response from a servlet 
- Sending a JSON object via mapping with Jackson
- Front controller design pattern

## Client/Server Architecture
- A Client and a Server establish a connection according to a set of rules called a protocol. 
- [**HTTP**](https://developer.mozilla.org/en-US/docs/Web/HTTP/Overview) is a protocol which allows the fetching of resources, such as HTML documents. 
    - It is the foundation of any data exchange on the Web and it is a **client-server protocol**, which means requests are initiated by the recipient, usually the Web browser (client).
- *Describe the difference between **2 Tier**, **3 Tier**, **n-Tier** architecture*

### HTTP
- HTTP request contents
  - HTTP version
  - URL
  - HTTP verb / method
  - Request Headers
  - Request Body
- HTTP response contents
  - HTTP version
  - Status code
  - Response Headers
  - Response Body
- HTTP verbs
  - GET
  - POST
  - PUT
  - DELETE
  - PATCH
  - HEAD
  - OPTIONS
  - TRACE
- **Response status codes**
  - 100-199: informational
  - 200-299: success
    - 201: Created
    - 204: No content
  - 300-399: redirect
    - 301: Moved permanently
    - 304: Not modified
  - 400-499: client error
    - 403: Forbidden
    - 404: Not Found
    - 405: Method not allowed
    - 415: Unsupported media type
    - 451: Unavailable for legal reasons
  - 500-599: server error
    - 501: Not implemented
    - 502: Bad Gateway
    - 503: Service unavailable

## Overview of HTML/CSS/JavaScript
*These are the general topics that you should look into.  Refer to our class notes or Google for continued study*

- **HTML 5**
  - Markup Language
  - DOCTYPE declaration:
    - All HTML documents must start with a <!DOCTYPE> declaration. The declaration is not an HTML tag. It is an "information" to the browser about what document type to expect.
  - Miscellaneous tags - *list some*
  - Forms
- **CSS - Cascading Style Sheets**
  - Ways to include CSS
    - Inline styling
    - External styling
    - Internal styling
  - Different Selectors - *list some*
  - Bootstrap (current version is 4)
    - Mobile-first responsive CSS-framework

## JavaScript Language Fundamentals

1.  What is JavaScript? What do we use it for?
2.  Can we run JavaScript in a web browser, on a server, or both?
3.  [What programming paradigm(s) does JS support?](https://medium.com/javascript-in-plain-english/what-are-javascript-programming-paradigms-3ef0f576dfdb)
    > JavaScript is a prototype-based, multi-paradigm scripting language that is dynamic, and supports object-oriented, imperative, and functional programming styles.
4.  What are the data types in JS?
    - What is the type of NaN? What is the isNaN function?
    - What is the data type of a function?
    - What about an array?
    - What is the difference between undefined and null?
5.  What are JS objects? what is the syntax?
6.  What is JSON? Is it different from JS objects?
    > Unlike JavaScript Object, a JSON Object has to be fed into a variable as a String and then parsed into JavaScript. A framework like jQuery can be very helpful when doing parsing.
7.  What are some ways you can use functions in JS?
8.  What are the different scopes of variables in JS?
    - What are the different ways to declare global variables?
    - Is it a best practice to use global variables? Why or why not?
9.  What is function and variable hoisting?
10.  What is the global object in client-side JavaScript?
    - What are some built-in functions (methods on the global object)? 
11. What are callback functions? What about self-invoking functions?
12.  What is closure and when should you use it?
13.  Use the object literal syntax to create an object with some properties
14.  What is a truthy or falsy value? List the falsy values.
15.  What is the difference between == and ===? Which one allows for type coercion?
16.  Explain the template literal syntax
17.  What are arrays in JS? can you change their size?
18.  Explain what “strict mode” does
19.  Explain how inheritance works in JS
20.  What does the "this" keyword refer to?
21.  Explain the concept of lexical scope
22.  What will happen when I try to run this code: console.log(0.1+0.2==0.3) ?
    
### ES6+
27.  What new features did ES6 introduce?
28.  What is the difference between var, let, and const keywords?
31.  Does JS have classes? If so, when were they introduced?

### Events and DOM
39.  What is the DOM? How is it represented as a data structure? What object in a browser environment allows us to interact with the DOM?
40.  List some ways of querying the DOM for elements
41.  How would you insert a new element into the DOM?
42.  What are event listeners? What are some events we can listen for? What are some different ways of setting event listeners?
44.  What are some methods on the event object and what do they do?
