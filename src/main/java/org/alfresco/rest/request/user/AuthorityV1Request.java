package org.alfresco.rest.request.user;

import com.jayway.restassured.response.Response;
import org.alfresco.rest.request.AbstractV1Request;
import org.alfresco.rest.request.executor.RequestType;
import org.springframework.context.annotation.Scope;

public class AuthorityV1Request extends AbstractV1Request
{

	public void createUser(String username, String password)
	{
		System.out.println("API V1 Create User");
		//executor.executeV1Query(RequestType.PUT, url)
	}

	public void createGroup(String name)
	{
		System.out.println("API V1 Create Group");
		//executor.executeV1Query(RequestType.PUT, url)
	}
	
	public void listUsers()
	{
		Response users = executor.executeV1Query(RequestType.GET, getURL());
		System.out.println(users.getBody().prettyPrint());
	}
}
