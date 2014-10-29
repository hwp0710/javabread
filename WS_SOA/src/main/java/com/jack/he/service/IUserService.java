package com.jack.he.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import com.jack.he.dao.UserException;
import com.jack.he.model.User;

@WebService(name = "IUserService", targetNamespace = "http://service.he.jack.com")
public interface IUserService {

	/**
	 * 
	 * @param user
	 * @throws UserException
	 */
	@WebMethod
	@RequestWrapper(localName = "add", targetNamespace = "http://service.he.jack.com")
	@ResponseWrapper(localName = "addResponse", targetNamespace = "http://service.he.jack.com")
	public void add(@WebParam(name = "user", targetNamespace = "") User user) throws UserException;

	/**
	 * 
	 * @param username
	 * @throws UserException
	 */
	@WebMethod
	@RequestWrapper(localName = "delete", targetNamespace = "http://service.he.jack.com")
	@ResponseWrapper(localName = "deleteResponse", targetNamespace = "http://service.he.jack.com")
	public void delete(@WebParam(name = "username", targetNamespace = "") String username) throws UserException;

	/**
	 * 
	 * @return returns java.util.List<com.jack.he.service.User>
	 */
	@WebMethod
	@WebResult(name = "user", targetNamespace = "")
	@RequestWrapper(localName = "list", targetNamespace = "http://service.he.jack.com")
	@ResponseWrapper(localName = "listResponse", targetNamespace = "http://service.he.jack.com")
	public List<User> list();

	/**
	 * 
	 * @param username
	 * @param password
	 * @return returns com.jack.he.service.User
	 * @throws UserException
	 */
	@WebMethod
	@WebResult(name = "user", targetNamespace = "")
	@RequestWrapper(localName = "login", targetNamespace = "http://service.he.jack.com")
	@ResponseWrapper(localName = "loginResponse", targetNamespace = "http://service.he.jack.com")
	public User login(@WebParam(name = "username", targetNamespace = "http://service.he.jack.com") String username, @WebParam(name = "password", targetNamespace = "http://service.he.jack.com") String password) throws UserException;

	/**
	 * 
	 * @param file
	 */
	@WebMethod
	@RequestWrapper(localName = "upload", targetNamespace = "http://service.he.jack.com")
	@ResponseWrapper(localName = "uploadResponse", targetNamespace = "http://service.he.jack.com")
	public void upload(@WebParam(name = "file", targetNamespace = "http://service.he.jack.com") byte[] file);

}
