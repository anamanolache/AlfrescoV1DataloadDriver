package org.alfresco.Rest;

import org.alfresco.rest.request.user.AuthorityV1Request;
import org.junit.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.*;
import com.jayway.restassured.specification.RequestSpecification;

public class RestWrapper {

	@Test
	public void randomTest()
	{
		RequestSpecification basic = RestAssured.given().auth().preemptive().basic("admin", "admin");
		Response restResponse = basic.get("http://192.168.56.101:8080/alfresco/api/-default-/public/alfresco/versions/1/nodes/6e5406c8-180e-4d4d-8a30-dd340f75af0e;1.0");
		restResponse.getBody().print();
	}
	
	@Test
	public void listUsers()
	{
		AuthorityV1Request authority = new AuthorityV1Request();
		authority.listUsers();
	}
}
