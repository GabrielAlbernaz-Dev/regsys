package br.com.regys.dto;

import java.sql.Date;

public record UserResponseDTO(String username, boolean emailValid, Date createdAt, Date updatedAt) {

	public UserResponseDTO(String username, boolean emailValid, Date createdAt, Date updatedAt)  {
		this.username = username;
		this.emailValid = emailValid;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
}
