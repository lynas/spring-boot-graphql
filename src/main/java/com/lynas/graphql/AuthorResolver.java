package com.lynas.graphql;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.lynas.model.Author;
import com.lynas.model.Post;
import com.lynas.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AuthorResolver implements GraphQLResolver<Author> {

    private final PostService postService;

    public List<Post> posts(Author author) {
        return postService.getPostByAuthorId(author.getId());
    }
}
