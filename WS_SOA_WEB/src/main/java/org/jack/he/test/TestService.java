package org.jack.he.test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.ws.soap.MTOMFeature;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;

import com.jack.he.service.IUserService;
import com.jack.he.service.LicenceInfo;
import com.jack.he.service.User;
import com.jack.he.service.UserException_Exception;
import com.jack.he.service.UserService;
import com.sun.xml.ws.api.message.Headers;
import com.sun.xml.ws.developer.WSBindingProvider;

public class TestService {
	private IUserService port;
	private UserService uerService;
	private String ns = "http://service.he.jack.com";

	@Before
	public void init() {
		try {
			URL url = new URL("http://localhost:8080/WS_SOA/us?wsdl");
			QName name = new QName(ns, "UserService");
			uerService = new UserService(url, name);
			port = uerService.getUserServicePort(new MTOMFeature());
			Class<?>[] c = port.getClass().getInterfaces();
			for (Class<?> cc : c) {
				System.out.println(cc.getName());
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testList() {
		List<User> list = port.list();

		for (User u : list) {
			System.out.println(u.getNickname());
		}
	}

	@Test
	public void testAdd() {
		try {
			// 1、将一个对象转换为xml通过JAXB
			JAXBContext ctx = JAXBContext.newInstance(LicenceInfo.class);
			User ru = new User();
			ru.setNickname("super admin user");
			ru.setUsername("admin");
			ru.setPassword("1232323");
			LicenceInfo info = new LicenceInfo();
			info.setRegisterUser(ru);
			QName name = new QName(ns, "licenceInfo");
			JAXBElement<LicenceInfo> jele = new JAXBElement<LicenceInfo>(name, LicenceInfo.class, info);
			Marshaller mars = ctx.createMarshaller();
			mars.setProperty(Marshaller.JAXB_FRAGMENT, true);
			mars.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");

			// 2、转换为DOM
			Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
			mars.marshal(jele, doc);

			// 3、通过Headers.create方法完成header的添加
			// 获取WSBindingProvider
			WSBindingProvider wsb = (WSBindingProvider) port;
			wsb.setOutboundHeaders(Headers.create(doc.getDocumentElement()));

			User u = new User();
			u.setNickname("zhangshan");
			u.setPassword("123");
			u.setUsername("zs");
			port.add(u);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	@Test
	public void testLogin() {
		try {
			User u = port.login("zs", "123");
			System.out.println(u.getUsername());
		} catch (UserException_Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void testDelete() {
		try {
			port.delete("zs");
		} catch (UserException_Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void testUpload() throws UserException_Exception {
		try {
			byte[] file = FileUtils.readFileToByteArray(new File("C:/temp/img/tree.jpg"));
			port.upload(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
