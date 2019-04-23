package com.friendbooks.friendsservice.entity;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name = "FriendRequest")
public class FriendRequest {
 
    @Id
    @GeneratedValue
    @Column(name = "Id", nullable = false)
    private Long id;
    
    @Column(name = "FromEmail", nullable = false)
    private String fromEmail;
 
    @Column(name = "ToEmail", nullable = false)
    private String toEmail;
    
    @Column(name = "Status", nullable = false)
    private String status;

    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }
    
	public String getFromEmail() {
		return fromEmail;
	}

	public void setFromEmail(String fromEmail) {
		this.fromEmail = fromEmail;
	}

	public String getToEmail() {
		return toEmail;
	}

	public void setToEmail(String toEmail) {
		this.toEmail = toEmail;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

 
}