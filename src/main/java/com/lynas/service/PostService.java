package com.lynas.service;

import com.lynas.dao.PostDao;
import com.lynas.model.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostDao postDao;

    public void saveAllPost(Iterable<Post> entities) {
        postDao.saveAll(entities);
    }

    public List<Post> getRecentPosts(int count, int offset) {
        return postDao.findAll();
    }

    public List<Post> getPostByAuthorId(String authorId) {
        return postDao.getByAuthorId(authorId);
    }


}
