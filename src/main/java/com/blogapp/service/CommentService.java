package com.blogapp.service;

import java.util.List;

import com.blogapp.entity.Comment;

public interface CommentService {

	public boolean addComment(int postId,Comment comment);
	public List<Comment> getCommentsByPostId(int postId);
	
}
