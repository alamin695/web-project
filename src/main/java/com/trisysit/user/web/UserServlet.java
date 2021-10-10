package com.trisysit.user.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trisysit.user.dao.UserDao;
import com.trisysit.user.model.User;

/**
 * 
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 * 
 * @email property of trisysit.com
 */

@WebServlet("/user")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDao;

	public void init() {
		userDao = new UserDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = "" + request.getParameter("action");
		System.out.println(action);
		try {
			switch (action) {
			case "save":
				saveUser(request, response);
				break;
			default:
				listUser(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void saveUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String idStr = request.getParameter("id");
		if (idStr != null && !idStr.isEmpty()) {
			updateUser(request, response);
		} else {
			insertUser(request, response);
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = "" + request.getParameter("action");
		System.out.println(action);
		try {
			switch (action) {
			case "new":
				showNewForm(request, response);
				break;
			case "edit":
				showEditForm(request, response);
				break;
			default:
				listUser(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<User> listUser = userDao.getUsers();
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user/listUser.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("user/addUser.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		User existingUser = userDao.selectUser(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user/addUser.jsp");
		request.setAttribute("user", existingUser);
		dispatcher.forward(request, response);

	}

	private void insertUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		String streetline1 = request.getParameter("streetline1");
		String streetline2 = request.getParameter("streetline2");
		String city = request.getParameter("city");
		int pin = Integer.parseInt(request.getParameter("pin"));
		String state = request.getParameter("state");

		User newUser = new User(name, email, country, streetline1, streetline2, city, pin,state);
		userDao.addUser(newUser);
		response.sendRedirect("user");
	}

	private void updateUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		String streetline1 = request.getParameter("streetline1");
		String streetline2 = request.getParameter("streetline2");
		String city = request.getParameter("city");
		int pin = Integer.parseInt(request.getParameter("pin"));
		String state = request.getParameter("state");

		User book = new User(id , name, email, country, streetline1, streetline2, city, pin,state);
		userDao.updateUser(book);
		response.sendRedirect("user");
	}

}
