package com.blogapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	
}
