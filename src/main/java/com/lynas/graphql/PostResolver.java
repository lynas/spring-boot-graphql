package com.lynas.graphql;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.lynas.dao.AuthorDao;
import com.lynas.model.Author;
import com.lynas.model.Post;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PostResolver implements GraphQLResolver<Post> {
    private final AuthorDao authorDao;

    public PostResolver(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    public Author getAuthor(Post post) {
        Optional<Author> author = authorDao.findById(post.getAuthorId());
        return author.orElse(null);
    }
}