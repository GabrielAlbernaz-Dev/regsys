package br.com.regys.dao;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.regys.config.ConnectionManager;
import br.com.regys.dto.UserResponseDTO;
import br.com.regys.models.User;

public class UserDAO {
	private Connection conn = null;
	
	public UserDAO() throws SQLException {
		this.conn = (Connection) ConnectionManager.getInstance().getConnection();
	}
	
	public List<UserResponseDTO> getUsers() throws SQLException {
		ArrayList<UserResponseDTO> users = new ArrayList<UserResponseDTO>();
		
		String getUsersSql = "SELECT username,email_valid,created_at,updated_at FROM users";
		Statement stmt = this.conn.createStatement();
		ResultSet rs = stmt.executeQuery(getUsersSql);
		
		while(rs.next()) {
			UserResponseDTO userRes = new UserResponseDTO(rs.getString("username"), rs.getBoolean("email_valid"), rs.getDate("created_at"), rs.getDate("updated_at"));
			users.add(userRes);
		}
		
		return users;
	}
	
	public boolean createUser(User user) throws NoSuchAlgorithmException {
		PreparedStatement stmt = null;
		
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		byte[] hash = digest.digest(user.getPassword().getBytes(StandardCharsets.UTF_8));
		
		StringBuilder hexString = new StringBuilder();
		for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
			if(hex.length() == 1) {
				hexString.append("0");
			}
			
			hexString.append(hex);
		}
		
		String passwordHashHex = hexString.toString();

		try {
			stmt = this.conn.prepareStatement("INSERT INTO users(username,password) VALUES(?,?)");
			stmt.setString(1, user.getUsername());
			stmt.setString(2, passwordHashHex);
			stmt.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
