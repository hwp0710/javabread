package org.jack.he.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jack.he.service.IUserService;
import com.jack.he.service.User;
import com.jack.he.service.UserException_Exception;
import com.jack.he.service.UserService;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IUserService port;
	private UserService userService;
       
    public UserServlet() {
        super();
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String method = request.getParameter("method");
		userService = new UserService();
		port = userService.getUserServicePort();
		if(method==null||"".equals(method)) {
			list(request,response);
		} else if(method.equals("add")) {
			add(request,response);
		} else if(method.equals("login")) {
			login(request,response);
		} else if(method.equals("delete")) {
			delete(request,response);
		}
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) {
		try {
			WebUtil.addLicenceHeader(port, request);
			String username = request.getParameter("username");
			port.delete(username);
			response.sendRedirect("user.do");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (UserException_Exception e) {
			e.printStackTrace();
		}
	}

	private void login(HttpServletRequest request, HttpServletResponse response) {
		try {
			try {
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				User u = port.login(username, password);
				request.getSession().setAttribute("loginUser", u);
			} catch (UserException_Exception e) {
				e.printStackTrace();
			}
			response.sendRedirect("user.do");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void add(HttpServletRequest request, HttpServletResponse response) {
		try {
			WebUtil.addLicenceHeader(port, request);
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String nickname = request.getParameter("nickname");
			
			try {
				User u = new User();
				u.setNickname(nickname);
				u.setPassword(password);
				u.setUsername(username);
				port.add(u);
			} catch (UserException_Exception e) {
				System.out.println(e.getMessage());
			}
			
			response.sendRedirect("user.do");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void list(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setAttribute("users", port.list());
			RequestDispatcher dis = request.getRequestDispatcher("list.jsp");
			dis.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
