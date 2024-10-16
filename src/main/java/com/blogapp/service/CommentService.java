package com.blogapp.service;

import com.blogapp.entity.Comment;

public interface CommentService {

	public boolean addComment(int postId,Comment comment);
	
	
}
