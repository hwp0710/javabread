package com.shengsiyuan.struts2;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.shengsiyuan.service.LoginService;
import com.shengsiyuan.service.impl.LoginServiceImpl;

public class LoginAction extends ActionSupport {
	private String username;

	private String password;

	private int age;

	private Date date;

	private LoginService loginService = new LoginServiceImpl();

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String execute() throws Exception {
		// if(!"hello".equals(username))
		// {
		// throw new UsernameException("username invalid");
		// }
		// if(!"world".equals(password))
		// {
		// throw new PasswordException("password invalid");
		// }
		//
		// return SUCCESS;

		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();

		session.setAttribute("hello", "helloworld");

		ActionContext actionContext = ActionContext.getContext();
		Map<String, Object> map = actionContext.getSession();

		Object object = map.get("hello");
		System.out.println(object);

		if (this.loginService.isLogin(username, password)) {
			return SUCCESS;
		}

		return INPUT;
	}

	public String myExecute() throws Exception {
		System.out.println("myExecute invoked!!");

		return SUCCESS;
	}

	public void validateMyExecute() {
		System.out.println("validateMyExecute invoked!!");

		this.addActionError("action error");
	}

	@Override
	public void validate() {
		// System.out.println("validate invoked!");

		// this.addActionError("action error");
	}

}
