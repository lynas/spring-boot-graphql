### Postman graphql query

- authors
- url : http://localhost:8080/graphql
- method : POST
- body

```
query{
    authors {
        id
        posts {
            id
            title
        }
    }
}
```