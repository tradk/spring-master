# Spring Boot - Rest Template
Rest Template is used to create application that consume RESTful Web Service. You
can use the **exchange()** method to consume the web services for all
HTTP method. 

### Spring Boot create Bean for Rest Template
```java
@Bean
public RestTemplate getRestTemplate() {
  return new RestTemplate();
}
```

### Create fake REST API with json-server
- Install json-server
```js
npm install -g json-server  
```
- Create json file dummy database(![database.json](https://github.com/tradk/spring-master/blob/master/springboot-resttemplate/database.json))
```json
{
  "products": [
    {
      "id": 1,
      "name": "Macbook-pro 2015",
      "category": "Laptops",
      "status": "unavailable",
      "price": 1000
    },
    {
      "id": 2,
      "name": "Dell MX1021",
      "category": "Laptops",
      "status": "available",
      "price": 400
    }
  ]
}
```
- Run json-server with file database.json
```javascript
json-server --watch database.json 
```