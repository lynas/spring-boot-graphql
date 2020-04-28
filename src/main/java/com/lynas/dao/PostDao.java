package com.lynas.dao;

import com.lynas.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;


public interface  PostDao extends JpaRepository<Post,String> {
}
