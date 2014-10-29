package org.jack.he.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;

import com.jack.he.service.IUserService;
import com.jack.he.service.LicenceInfo;
import com.jack.he.service.User;
import com.sun.xml.ws.api.message.Headers;
import com.sun.xml.ws.developer.WSBindingProvider;

public class WebUtil {
	private static String ns = "http://service.he.jack.com";

	public static void addLicenceHeader(IUserService port, HttpServletRequest request) {
		try {
			JAXBContext ctx = JAXBContext.newInstance(LicenceInfo.class);
			User ru = (User) request.getSession().getAttribute("loginUser");
			if (ru == null)
				return;
			LicenceInfo info = new LicenceInfo();
			info.setRegisterUser(ru);
			QName name = new QName(ns, "licenceInfo");
			JAXBElement<LicenceInfo> jele = new JAXBElement<LicenceInfo>(name, LicenceInfo.class, info);
			Marshaller mars = ctx.createMarshaller();
			mars.setProperty(Marshaller.JAXB_FRAGMENT, true);
			mars.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");

			Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
			mars.marshal(jele, doc);

			WSBindingProvider wsb = (WSBindingProvider) port;
			wsb.setOutboundHeaders(Headers.create(doc.getDocumentElement()));
		} catch (PropertyException e) {
			e.printStackTrace();
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
	}
}
