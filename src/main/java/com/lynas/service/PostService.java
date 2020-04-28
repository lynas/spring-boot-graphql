package com.lynas.service;

import com.lynas.dao.PostDao;
import com.lynas.model.Post;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PostService {
    private final PostDao postDao;

    public PostService(PostDao postDao) {
        this.postDao = postDao;
    }

    public void saveAllPost(Iterable<Post> entities){
        postDao.saveAll(entities);
    }

    public List<Post> getRecentPosts(int count, int offset) {
        return postDao.findAll();
    }
}
