package com.lynas.service;

import com.lynas.dao.AuthorDao;
import com.lynas.model.Author;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AuthorService {

    private final AuthorDao authorDao;

    public AuthorService(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    public List<Author> getAuthors() {
        return authorDao.findAll();
    }

    public void saveAllAuthors(Iterable<Author> entities) {
        authorDao.saveAll(entities);
    }

    public Author getAuthor(String id) {
        return authorDao.findById(id).orElse(null);
    }

}
