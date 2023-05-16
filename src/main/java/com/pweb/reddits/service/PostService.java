package com.pweb.reddits.service;

import com.pweb.reddits.entity.Post;
import com.pweb.reddits.repo.PostRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class PostService {

    @Autowired
    private PostRepo repo;

    public Iterable<Post> findAll() {
        return repo.findAll();
    }

    public void add(Post post) {
        repo.save(post);
    }

    public void removeById(Long id) {
        repo.deleteById(id);
    }

    public Optional<Post> findById(Long id) {
        return repo.findById(id);
    }

    public void update(Post post) {
        repo.save(post);
    }
}
