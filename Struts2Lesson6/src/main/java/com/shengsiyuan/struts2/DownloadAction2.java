package com.shengsiyuan.struts2;

import java.io.InputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class DownloadAction2 extends ActionSupport
{
	private int number;

	private String filename;

	public String getFilename()
	{
		return filename;
	}

	public void setFilename(String filename)
	{
		this.filename = filename;
	}

	public int getNumber()
	{
		return number;
	}

	public void setNumber(int number)
	{
		this.number = number;
	}

	public InputStream getDownloadFile()
	{
		try
		{
			if (1 == number)
			{
				this.filename = "中文圣思园文件下载.txt";

				this.filename = new String(this.filename.getBytes("gbk"),
						"8859_1");

				return ServletActionContext.getServletContext()
						.getResourceAsStream("/upload/中文圣思园文件下载.txt");
			}
			else
			{
				this.filename = "CaptureSprite.exe";

				return ServletActionContext.getServletContext()
						.getResourceAsStream("/upload/CaptureSprite.exe");
			}
		}
		catch (Exception ex)
		{

		}
		
		return null;
	}

	@Override
	public String execute() throws Exception
	{
		return SUCCESS;
	}
}
