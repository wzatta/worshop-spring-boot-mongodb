package com.cilazatta.workshopmongo.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.cilazatta.workshopmongo.domain.Post;

public class PostDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String idPost;
	private LocalDateTime date;
	private String title;
	private String body;
	private AuthorDTO author;
	
	private List<CommentDTO> comments = new ArrayList<>();
	
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")
			.withZone(ZoneId.systemDefault());
	DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	
	public PostDTO() {
		
	}

	public PostDTO(Post post) {
		this.idPost = post.getIdPost();
		this.date = LocalDateTime.parse(dtf.format(post.getDate()).toString(),dtf1);
		this.title = post.getTitle();
		this.body = post.getBody();
		this.author = post.getAuthor();
		this.comments = post.getComments();
	}

	public String getIdPost() {
		return idPost;
	}

	public void setIdPost(String idPost) {
		this.idPost = idPost;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public AuthorDTO getAuthor() {
		return author;
	}

	public void setAuthor(AuthorDTO author) {
		this.author = author;
	}

	public List<CommentDTO> getComments() {
		return comments;
	}

	public void setComments(List<CommentDTO> comments) {
		this.comments = comments;
	}
	

	
	
	
	
	
}
