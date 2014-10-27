package com.shengsiyuan.struts2;

import java.io.InputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class DownloadAction extends ActionSupport
{
	public InputStream getDownloadFile()
	{
		return ServletActionContext.getServletContext().getResourceAsStream(
				"/upload/comments.txt");
	}

	@Override
	public String execute() throws Exception
	{
		return SUCCESS;
	}
}
