package br.com.regys.services;

import java.sql.SQLException;
import java.util.List;

import br.com.regys.dao.UserDAO;
import br.com.regys.dto.UserResponseDTO;

public class UserService {
	private UserDAO dao = null;
	
	public UserService() throws SQLException {
		this.dao = new UserDAO();
	}
	
	public List<UserResponseDTO> getUsers() throws SQLException {
		return this.dao.getUsers();
	}
}
