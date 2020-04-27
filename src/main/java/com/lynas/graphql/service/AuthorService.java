package com.lynas.graphql.service;

import com.lynas.graphql.dao.AuthorDao;
import com.lynas.graphql.dao.PostDao;
import com.lynas.graphql.model.Author;
import com.lynas.graphql.model.Post;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AuthorService {

    private final AuthorDao authorDao;
    private final PostDao postDao;

    public AuthorService(AuthorDao authorDao, PostDao postDao) {
        this.authorDao = authorDao;
        this.postDao = postDao;
    }

    public List<Author> getAuthors() {
        List<Author> authorList = authorDao.findAll();
        authorList.forEach(author -> {
            Hibernate.initialize(author.getPosts());
        });
        return authorList;
    }

    public void saveAllAuthors(Iterable<Author> entities) {
        authorDao.saveAll(entities);
    }

    public Author getAuthor(String id) {
        Author author = authorDao.findById(id).get();
        Hibernate.initialize(author.getPosts());
        return author;
    }

}
