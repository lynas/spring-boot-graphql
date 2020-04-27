package com.lynas.graphql.dao;

import com.lynas.graphql.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface  PostDao extends JpaRepository<Post,String> {
    public List<Post> findAllByAuthorId(String authorId);
}
