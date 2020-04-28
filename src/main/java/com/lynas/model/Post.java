package com.lynas.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Post {
    @Id
    private String id;
    private String title;
    private String text;
    private String category;
    private String authorId;

    public Post() {
    }

    public Post(String id, String title, String text, String category, String authorId) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.category = category;
        this.authorId = authorId;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", category='" + category + '\'' +
                ", authorId='" + authorId + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

}
