package com.lynas.graphql.dao;

import com.lynas.graphql.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  AuthorDao extends JpaRepository<Author,String> {
}
