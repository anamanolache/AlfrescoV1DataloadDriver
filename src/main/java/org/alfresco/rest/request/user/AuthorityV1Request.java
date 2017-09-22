package org.alfresco.rest.request.user;

import com.jayway.restassured.response.Response;
import org.alfresco.rest.request.AbstractV1Request;
import org.alfresco.rest.request.executor.RequestType;

public class AuthorityV1Request extends AbstractV1Request
{

	public void createUser(String username, String password)
	{
		//executor.executeV1Query(RequestType.PUT, url)
	}
	
	public void listUsers()
	{
		Response users = executor.executeV1Query(RequestType.GET, "http://192.168.56.101:8080/alfresco/api/-default-/public/alfresco/versions/1/people");
		System.out.println(users.getBody().prettyPrint());
	}
}
