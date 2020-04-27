package com.lynas.graphql;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.lynas.graphql.dao.AuthorDao;
import com.lynas.graphql.model.Author;
import com.lynas.graphql.model.Post;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PostResolver implements GraphQLResolver<Post> {
    private final AuthorDao authorDao;

    public PostResolver(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    public Author getAuthor(Post post) {
        Optional<Author> byId = authorDao.findById(post.getAuthorId());
        return byId.get();
    }
}
