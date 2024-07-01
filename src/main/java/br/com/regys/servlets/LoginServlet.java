package br.com.regys.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.regys.config.ConnectionManager;
import br.com.regys.dao.UserDAO;
import br.com.regys.models.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO dao = new UserDAO();
       
    /**
     * @throws SQLException 
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() throws SQLException {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = (RequestDispatcher) request.getRequestDispatcher("/login.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		User user = new User(username,password);
		
		boolean userCreated = false;
		
		try {
			userCreated = this.dao.createUser(user);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			userCreated = false;
		}
		
		if(!userCreated) {
			response.getWriter().append("<p style='color:red;'>Não foi possível salvar o usuário " + username + "</p>");
			return;
		}
		
		response.getWriter().append("<p style='color:green;'>Usuário: " + username + "salvo com sucesso!</p>");
	}         
}
