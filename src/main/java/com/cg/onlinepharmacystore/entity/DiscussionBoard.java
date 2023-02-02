package com.cg.onlinepharmacystore.entity;

import javax.persistence.Entity;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "DiscussionBoard")
public class DiscussionBoard {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Discussion_Id")
	private Long discussionId;
	@Column(name="User_Name")
	private String userName;
	@Column(name="User_Email")
	@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}")
	private String userEmail;
	@Column(name="Message")
	private String message;
	

	
	public DiscussionBoard() {
		super();
	}
	public DiscussionBoard(Long discussionId, String userName, String userEmail,String message) {
		super();
		this.discussionId = discussionId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.message = message;
		
	}
	

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	
	@Override
	public String toString() {
		return "DiscussionBoard [DiscussionId=" + discussionId + ", UserName=" + userName+ ", Message=" + message
				+", UserEmail=" + userEmail+ "]";
	}	
}