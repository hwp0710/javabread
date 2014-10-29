package com.test.webservice;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import com.sun.jersey.spi.resource.Singleton;
import com.test.webservice.model.PeopleConvert;

@Singleton
@Path("/people")
public class PeopleResource {
	@SuppressWarnings("unused")
	@Context
	private UriInfo context;

	/** Creates a new instance of PeopleResource */
	public PeopleResource() {
		System.out.println("PeopleResource constrocuter");
	}

	@GET
	@Path("")
	@Produces("application/json")
	public PeopleConvert getPeopleByJson(@QueryParam("name") String name) {
		System.out.println("method is getPeople ..");
		PeopleConvert people = new PeopleConvert();
		people.setId(1);
		people.setName(name);
		people.setType(0);
		return people;
	}

	@GET
	@Path("")
	@Produces("application/xml")
	public PeopleConvert getPeopleByXml(@QueryParam("name") String name) {
		System.out.println("method is getPeople ..");
		PeopleConvert people = new PeopleConvert();
		people.setId(1);
		people.setName(name);
		people.setType(0);
		return people;
	}

	@PUT
	@Consumes("application/xml")
	public PeopleConvert updatePeople(PeopleConvert convert) {
		System.out.println("method is updatePeople ..");
		convert.setLastUpdate(new Date());
		return convert;
	}

	@POST
	public PeopleConvert createPeople(PeopleConvert convert) {
		System.out.println("method is createPeople ..");
		convert.setLastUpdate(new Date());
		convert.setCreateUpdate(new Date());
		convert.setId(10);
		return convert;
	}

	@DELETE
	@Path("{id}")
	public String deletePeople(@PathParam("id") int id) {
		System.out.println("method is deletePeople .. id :" + id);
		return "delete is ok ! " + id;
	}

	@GET
	@Path("/list")
	@Produces("application/xml")
	public Set<PeopleConvert> getPeoples(@QueryParam("name") String name) {
		Set<PeopleConvert> list = new HashSet<PeopleConvert>();
		System.out.println("method is getPeople list ..");
		PeopleConvert people = new PeopleConvert();
		people.setId(1);
		people.setName(name + "-0");
		people.setType(0);
		list.add(people);
		people = new PeopleConvert();
		people.setId(2);
		people.setName(name + "-2");
		people.setType(0);
		list.add(people);
		return list;
	}
}