package com.blogapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogapp.entity.Comment;
import com.blogapp.service.CommentServiceImpl;


@RestController
@RequestMapping("/comment/{postId}")
public class CommentController {

	
	@Autowired
	private CommentServiceImpl commentServiceImpl;

	//post api
	@PostMapping
	public ResponseEntity<String> addComment
	(@PathVariable int postId,@RequestBody Comment comment){
		System.out.println(postId);
		System.out.println(comment);
		boolean isCommentAdded=commentServiceImpl.addComment(postId, comment);
		if(isCommentAdded) {
			return new ResponseEntity<String>
			("Comment added Successfully",HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>
			("Oops.. Comment not added",HttpStatus.NOT_MODIFIED);
		}
		
	}

	@GetMapping
	public ResponseEntity<List<Comment>> getCommentsByPostId(@PathVariable int postId) {
		List<Comment> comments = commentServiceImpl.getCommentsByPostId(postId);
		if (!comments.isEmpty()) {
			return new ResponseEntity<>(comments, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
