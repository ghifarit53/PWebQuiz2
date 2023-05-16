package com.pweb.reddits.entity;

public class Post {
    private long id;
    private String text;
    private String slug;
    private String timestamp;

    public Post() {
    }

//    public Post(long id, String text, String slug, String timestamp) {
//        this.id = id;
//        this.text = text;
//        this.slug = slug;
//        this.timestamp = timestamp;
//    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
