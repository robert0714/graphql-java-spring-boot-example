# graphql-java-spring-boot-example
Sample app for my tutorial [Building a GraphQL Server with Spring Boot](https://www.pluralsight.com/guides/java-and-j2ee/building-a-graphql-server-with-spring-boot). 

https://www.pluralsight.com/guides/building-a-graphql-server-with-spring-boot

https://www.baeldung.com/spring-graphql



Clone this repo and execute `mvnw spring-boot:run`. Or inside an IDE, execute the class `com.example.DemoGraphQL.DemoGraphQlApplication`.

You can go to [http://localhost:8080/h2-console/login.jsp](http://localhost:8080/h2-console/login.jsp) and enter the following information:
- JDBC URL: jdbc:h2:mem:testdb
- User Name: sa
- Password: <blank>

To check the database or to [http://localhost:8080/graphiql](http://localhost:8080/graphiql) to start executing queries. For example:

```
{
  findAllBooks {
    id
    isbn
    title
    pageCount
    author {
      firstName
      lastName
    }
  }
}
```

Or:

```
mutation {
  newBook(
    title: "Java: The Complete Reference, Tenth Edition", 
    isbn: "1259589331", 
    author: 1) {
      id title
  }
}
```


Or Use Postman

You need to notice escape symbol .
<img src="pic/001.png" />

```
{"query":"{\n  findAllBooks {\n    id\n    isbn\n    title\n    pageCount\n    author {\n      firstName\n      lastName\n    }\n  }\n}","variables":null}
```

<img src="pic/002.png" />


# License
MIT

## REference
https://github.com/graphql-java-kickstart/graphql-spring-boot
