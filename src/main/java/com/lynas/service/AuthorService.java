package com.lynas.service;

import com.lynas.dao.AuthorDao;
import com.lynas.model.Author;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AuthorService {

    private final AuthorDao authorDao;

    public AuthorService(AuthorDao authorDao) {
        this.authorDao = authorDao;
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
        Optional<Author> author = authorDao.findById(id);
        if (author.isPresent()) {
            Hibernate.initialize(author.get().getPosts());
            return author.get();
        }
        return null;
    }

}
