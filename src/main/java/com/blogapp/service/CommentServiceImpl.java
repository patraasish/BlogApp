package com.blogapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogapp.entity.Comment;
import com.blogapp.entity.Post;
import com.blogapp.repository.CommentRepository;
import com.blogapp.repository.PostRepository;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private PostServiceImpl postServiceImpl;
	
	@Autowired
	private CommentRepository commentRepository;
	
	@Override
	public boolean addComment(int postId,Comment comment) {
		Post post=postServiceImpl.getById(postId);
		System.out.println("csi ..."+post);
		if(post!=null) {
			comment.setPost(post);
			Comment commentResponse=commentRepository.save(comment);
			System.out.println("comment res"+commentResponse);
			return true;
		}

		else {
			return false;
		}
	}

}
