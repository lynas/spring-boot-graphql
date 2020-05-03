package com.lynas.graphql;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.lynas.dao.AuthorRepository;
import com.lynas.model.Author;
import com.lynas.model.Post;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PostResolver implements GraphQLResolver<Post> {
    private final AuthorRepository authorRepository;

    public PostResolver(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author getAuthor(Post post) {
        Optional<Author> author = authorRepository.findById(post.getAuthorId());
        return author.orElse(null);
    }
}
