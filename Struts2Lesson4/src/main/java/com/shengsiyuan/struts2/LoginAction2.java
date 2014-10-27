package com.shengsiyuan.struts2;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.shengsiyuan.bean.Person;

@SuppressWarnings("serial")
public class LoginAction2 extends ActionSupport implements ModelDriven<Person>,
		Preparable {
	private Person person = new Person();

	@Override
	public Person getModel() {
		System.out.println("getModel invoked!");

		return person;
	}

	@Override
	public void prepare() throws Exception {
		System.out.println("prepare invoked!!");
	}

	@Override
	public String execute() throws Exception {
		System.out.println("execute invoked!");

		// System.out.println(person.getUsername());

		return SUCCESS;
	}
}
