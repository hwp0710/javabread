package com.jack.he.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.jack.he.model.User;

public class UserDao {
	private static final Map<String, User> users = new HashMap<String, User>();
	private static UserDao dao = null;

	private UserDao() {
		users.put("admin", new User("admin", "123", "super admin user!"));
	}

	public static UserDao newInstance() {
		if (dao == null)
			dao = new UserDao();
		return dao;
	}

	public Set<String> listUsers() {
		return users.keySet();
	}

	public User loadByUsername(String username) {
		return users.get(username);
	}

	public void add(User user) throws UserException {
		if (users.containsKey(user.getUsername()))
			throw new UserException("user exgist!");
		users.put(user.getUsername(), user);
	}

	public void delete(String username) {
		users.remove(username);
	}

	public List<User> list() {
		Set<String> keys = users.keySet();
		List<User> list = new ArrayList<User>();
		for (String key : keys) {
			list.add(users.get(key));
		}
		return list;
	}

	public User login(String username, String password) throws UserException {
		if (!users.containsKey(username))
			throw new UserException("user not exgist!");
		User u = users.get(username);
		if (!password.equals(u.getPassword()))
			throw new UserException("password is not correct!");
		return u;
	}
}
