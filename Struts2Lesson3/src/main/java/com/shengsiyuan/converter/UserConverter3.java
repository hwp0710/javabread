package com.shengsiyuan.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.apache.struts2.util.StrutsTypeConverter;

import com.shengsiyuan.bean.User;

public class UserConverter3 extends StrutsTypeConverter
{
	@Override
	public Object convertFromString(Map context, String[] values, Class toClass)
	{
		List<User> list = new ArrayList<User>();

		for (String value : values)
		{
			StringTokenizer st = new StringTokenizer(value, ";");

			User user = new User();

			user.setUsername(st.nextToken());
			user.setPassword(st.nextToken());

			list.add(user);
		}

		return list;
	}

	@Override
	public String convertToString(Map context, Object o)
	{
		List<User> list = (List<User>) o;

		StringBuffer buffer = new StringBuffer();

		for (User user : list)
		{
			String username = user.getUsername();
			String password = user.getPassword();

			buffer.append("username: ").append(username).append(" ,password: ")
					.append(password).append(" ");
		}

		return buffer.toString();
	}
}
