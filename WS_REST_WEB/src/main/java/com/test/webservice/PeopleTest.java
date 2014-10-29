package com.test.webservice;

import java.util.Collection;

import javax.ws.rs.core.MediaType;

import org.junit.Test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.test.webservice.model.PeopleConvert;

public class PeopleTest {
	final static String UrlBase = "http://localhost:8080/WS_REST_WEB/people";

	private WebResource getResource() {
		ClientConfig cc = new DefaultClientConfig();
		Client client = Client.create(cc);
		WebResource wr = client.resource(UrlBase);
		return wr;
	}

	@Test
	public void getPeople() {
		System.out.println("*********************************************************");
		System.out.println("");
		System.out.println("test get method begin ");
		WebResource wr = getResource();
		String json = wr.queryParam("name", "jack").accept(MediaType.APPLICATION_JSON).get(String.class);
		if (json != null) {
			System.out.println(" " + json.toString());
		}
		PeopleConvert people = wr.queryParam("name", "jack").accept(MediaType.APPLICATION_JSON).get(PeopleConvert.class);
		if (people != null) {
			System.out.println("people :" + people.getName());
		}
		System.out.println("test get method end ");
		System.out.println("*********************************************************");
		System.out.println("");
	}

	@Test
	public void updatePeople() {
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("*********************************************************");
		System.out.println("");
		System.out.println("test put method begin ");
		WebResource wr = getResource();
		PeopleConvert convert = wr.queryParam("name", "jack").accept(MediaType.APPLICATION_XML).get(PeopleConvert.class);
		if (convert != null) {
			System.out.println("people update before  :" + convert.getName());
			convert.setName("tom");
			PeopleConvert response = wr.type("application/xml").put(PeopleConvert.class, convert);
			if (response != null) {
				System.out.println("people update end  :" + convert.getName());
			}
		}
		System.out.println("test put method end ");
		System.out.println("*********************************************************");
		System.out.println("");
	}

	@Test
	public void addPeople() {
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("*********************************************************");
		System.out.println("");
		System.out.println("test post method begin ");
		WebResource wr = getResource();
		PeopleConvert people = new PeopleConvert();
		people.setId(1);
		people.setName("tom");
		people.setType(0);
		PeopleConvert response = wr.type("application/xml").post(PeopleConvert.class, people);
		if (response != null) {
			System.out.println("peolpe add :" + response.getName());
		} else {
			System.out.println("peolpe  is null");
		}
		System.out.println("test post method end ");
		System.out.println("*********************************************************");
		System.out.println("");
	}

	@Test
	public void deletePeople() {
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("*********************************************************");
		System.out.println("");
		System.out.println("test delete method begin ");
		WebResource wr = getResource();
		String response = wr.path("/1").type("application/xml").delete(String.class);
		if (response != null) {
			System.out.println("delete :" + response);
		} else {
			System.out.println("delete is null");
		}
		System.out.println("test delete method end ");
		System.out.println("*********************************************************");
		System.out.println("");
	}

	@Test
	public void getPeopleList() {
		System.out.println("*********************************************************");
		System.out.println("");
		System.out.println("test get method  list people begin ");
		WebResource wr = getResource();
		GenericType<Collection<PeopleConvert>> genericType = new GenericType<Collection<PeopleConvert>>() {
		};
		Collection<PeopleConvert> peoples = wr.path("/list").queryParam("name", "jack").accept(MediaType.APPLICATION_XML).get(genericType);
		if (peoples != null) {
			for (PeopleConvert people : peoples) {
				System.out.println("list people :" + people.getName());
			}
		}
		System.out.println("test get method list people  end ");
		System.out.println("*********************************************************");
		System.out.println("");
	}

	// public static void main(String[] args) {
	// PeopleClient client = new PeopleClient();
	// client.getPeople();
	// client.updatePeople();
	// client.addPeople();
	// client.deletePeople();
	// client.getPeopleList();
	// }
}