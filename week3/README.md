# Study Guide for QC on Monday Nov. 16th, 2020
*Remember that you will also have to refer to [Week 2's QC study guide](https://github.com/201026-reston-java-msa/demos/blob/main/week2/README.md) because you may be asked questions on SQL.*

### Topics Covered in Week 3:
* HTML
* CSS
* AWS S3
* Servlets
* JavaScript
> I will update this with more information soon.

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
