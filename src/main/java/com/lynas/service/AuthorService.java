package com.lynas.service;

import com.lynas.dao.AuthorRepository;
import com.lynas.model.Author;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }

    public void saveAllAuthors(Iterable<Author> entities) {
        authorRepository.saveAll(entities);
    }

    public Author getAuthor(String id) {
        return authorRepository.findById(id).orElse(null);
    }

}
