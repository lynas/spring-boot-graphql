package com.lynas.service;

import com.lynas.dao.PostRepository;
import com.lynas.model.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public void saveAllPost(Iterable<Post> entities) {
        postRepository.saveAll(entities);
    }

    public List<Post> getRecentPosts(int count, int offset) {
        return postRepository.findAll();
    }

    public List<Post> getPostByAuthorId(String authorId) {
        return postRepository.getByAuthorId(authorId);
    }


}
