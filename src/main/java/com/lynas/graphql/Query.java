package com.lynas.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.lynas.graphql.dao.AuthorDao;
import com.lynas.graphql.dao.PostDao;
import com.lynas.graphql.model.Author;
import com.lynas.graphql.model.Post;
import com.lynas.graphql.service.AuthorService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Query implements GraphQLQueryResolver {
    private final PostDao postDao;
    private final AuthorService authorService;

    public Query(PostDao postDao, AuthorDao authorDao, AuthorService authorService) {
        this.postDao = postDao;
        this.authorService = authorService;
    }

    public List<Post> getRecentPosts(int count, int offset) {
        return postDao.findAll();
    }

    public List<Author> getAuthors() {
        return authorService.getAuthors();
    }

    public Author getAuthor(String id) {
        return authorService.getAuthor(id);
    }
}
