package com.lynas.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.lynas.dao.AuthorDao;
import com.lynas.dao.PostDao;
import com.lynas.model.Author;
import com.lynas.model.Post;
import com.lynas.service.AuthorService;
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
