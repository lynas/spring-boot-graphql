package com.lynas.dao;

import com.lynas.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface  PostDao extends JpaRepository<Post,String> {
    List<Post> getByAuthorId(String authorId);
}
