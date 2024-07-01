package br.com.regys.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {
	private static ConnectionManager instance = null;
	private final String url = "jdbc:mysql://localhost:3306/regsys";
	private final String username = "root";
	private final String password = "";
	
	static {
	    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
      } catch (ClassNotFoundException e) {
        System.out.println(e.getMessage());
      }
	}
	
	public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(this.url, this.username, this.password);
	}
	
    public static ConnectionManager getInstance() throws SQLException {
        if (instance == null) {
            instance = new ConnectionManager();
        } else if (instance.getConnection().isClosed()) {
            instance = new ConnectionManager();
        }

        return instance;
    }
}
