# spring-boot-versioning
This is the code for the following blog.

# Running the Example
Checkout the code, build and run the application.
```bash
git clone https://github.com/johndobie/spring-boot-versioning.git
mvn clean install spring-boot:run
```

Test The Application.
```bash 
$ curl -X POST http://localhost:8080/user -H 'Content-Type: application/json' -d '{"id":1,"firstName":"John","lastName":"Doe","age":50,"address":null,"loginDetails":null}'


```
