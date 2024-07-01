package br.com.regys.models;

import java.time.LocalDateTime;

public class User {
	private String username;
	private String password;
	private boolean emailValid;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
	public User() {}
	
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEmailValid() {
		return emailValid;
	}

	public void setEmailValid(boolean emailValid) {
		this.emailValid = emailValid;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
}
