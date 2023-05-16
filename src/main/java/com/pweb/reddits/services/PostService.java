package com.pweb.reddits.services;

import com.pweb.reddits.entity.Post;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.Normalizer;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class PostService {

    private static long id = 0;

    private static List<Post> posts = new ArrayList<Post>();

    public List<Post> findAll() {
        List<Post> reversedPosts = new ArrayList<>(posts);
        Collections.reverse(reversedPosts);
        return reversedPosts;
    }

    public Post findPostBySlug(String slug) {
        for (Post p : posts) {
            if (p.getSlug().equals(slug)) {
                return p;
            }
        }

        return null;
    }

    public void removePostById(long id) {
        posts.removeIf(post -> post.getId() == id);
    }

    private String slugify(String text, String divider) {
        LocalDateTime now = LocalDateTime.now();
        String timestamp = now.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));

        // Replace non-letter or digits by divider
        text = text.replaceAll("[^\\p{L}\\p{N}]+", divider);

        // Transliterate
        text = Normalizer.normalize(text, Normalizer.Form.NFKD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");

        // Remove unwanted characters
        text = text.replaceAll("[^\\-\\w]+", "");

        // Trim
        text = text.trim().replaceAll("^" + divider + "+|" + divider + "+$", "");

        // Remove duplicate divider
        text = text.replaceAll("-+", divider);

        // Lowercase
        text = text.toLowerCase();

        if (text.isEmpty()) {
            text = "n-a";
        }

        // Trim slug to max 128 characters
        String slug = timestamp + divider + text;
        slug = slug.substring(0, Math.min(slug.length(), 64));

        // Remove trailing divider if present
        if (slug.endsWith(divider)) {
            slug = slug.substring(0, slug.length() - 1);
        }

        return slug;
    }

    public void addPost(Post post) {
        post.setId(id++);
        post.setSlug(slugify(post.getText(), "-"));

        SimpleDateFormat sdf = new SimpleDateFormat("MMM d, yyyy 'at' h:mm a");
        post.setTimestamp(sdf.format(new Timestamp(System.currentTimeMillis())));
        posts.add(post);
    }
}
