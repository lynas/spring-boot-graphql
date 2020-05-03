package com.lynas.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.lynas.dao.AuthorRepository;
import com.lynas.dao.PostRepository;
import com.lynas.model.Author;
import com.lynas.model.Post;
import com.lynas.service.AuthorService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Query implements GraphQLQueryResolver {
    private final PostRepository postRepository;
    private final AuthorService authorService;

    public Query(PostRepository postRepository, AuthorRepository authorRepository, AuthorService authorService) {
        this.postRepository = postRepository;
        this.authorService = authorService;
    }

    public List<Post> getRecentPosts(int count, int offset) {
        return postRepository.findAll();
    }

    public List<Author> getAuthors() {
        return authorService.getAuthors();
    }

    public Author getAuthor(String id) {
        return authorService.getAuthor(id);
    }
}
