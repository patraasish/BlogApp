package com.blogapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogapp.entity.Post;
import com.blogapp.service.PostServiceImpl;

@RestController
@RequestMapping("/post")
public class PostController {

	@Autowired
	private PostServiceImpl postServiceImpl;
	
	@PostMapping
	public ResponseEntity<Post> addPost(@RequestBody Post post){
		
		System.out.println(post.toString());
		return new ResponseEntity<Post>(postServiceImpl.addPost(post),HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Post>> getPosts() {
		
		return new ResponseEntity<List<Post>>
		(postServiceImpl.getAllPosts(),HttpStatus.OK);
	}
	
}
