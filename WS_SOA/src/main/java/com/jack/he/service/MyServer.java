package com.jack.he.service;

import javax.xml.ws.Endpoint;

public class MyServer {

	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8081/WS_SOA/us", new UserServiceImpl());
		System.out.print("start success....");
	}

}
