package com.lynas.dao;

import com.lynas.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  AuthorDao extends JpaRepository<Author,String> {
}
