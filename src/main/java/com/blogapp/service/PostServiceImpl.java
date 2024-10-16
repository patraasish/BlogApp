package com.blogapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogapp.entity.Post;
import com.blogapp.repository.PostRepository;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepository postRepository;
	
	@Override
	public Post addPost(Post post) {
		return postRepository.save(post);
	}
	
	@Override
	public List<Post> getAllPosts(){
		return postRepository.findAll();
	}

	@Override
	public Post getById(int id) {
		return postRepository.findById(id).get();
	}
	
	

}
