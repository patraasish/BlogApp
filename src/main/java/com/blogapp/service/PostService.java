package com.blogapp.service;

import java.util.List;
import java.util.Optional;

import com.blogapp.entity.Post;

public interface PostService {

	public Post addPost(Post post);
	public List<Post> getAllPosts();
	public Post getById(int id);
	
}
