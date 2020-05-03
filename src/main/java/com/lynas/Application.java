package com.lynas;

import com.lynas.model.Author;
import com.lynas.model.Post;
import com.lynas.service.AuthorService;
import com.lynas.service.PostService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Arrays;
import java.util.UUID;

@EnableTransactionManagement
@SpringBootApplication
public class Application {
    @Bean
    CommandLineRunner commandLineRunner(PostService postService, AuthorService authorService) {
        return args -> {
            String author1id = UUID.randomUUID().toString();
            String author2id = UUID.randomUUID().toString();
            Post post1 = new Post(UUID.randomUUID().toString(), "t1", "txt1", "c1", author1id);
            Post post2 = new Post(UUID.randomUUID().toString(), "t2", "txt2", "c2", author1id);
            Post post3 = new Post(UUID.randomUUID().toString(), "t3", "txt3", "c3", author2id);
            Post post4 = new Post(UUID.randomUUID().toString(), "t4", "txt4", "c4", author2id);
            Post post5 = new Post(UUID.randomUUID().toString(), "t5", "txt5", "c5", author2id);
            postService.saveAllPost(Arrays.asList(post1, post2, post3, post4, post5));

            Author author1 = new Author(author1id, "n1", "t1");
            Author author2 = new Author(author2id, "n2", "t2");

            authorService.saveAllAuthors(Arrays.asList(author1, author2));

            System.out.println("\n\n ===Printing===\n\n");
            postService.getRecentPosts(1, 1).forEach(System.out::println);
            System.out.println("\n\n ===Printing===\n\n");
            authorService.getAuthors().forEach(System.out::println);
            System.out.println("\n\n ===Printing===\n\n");

        };

    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
