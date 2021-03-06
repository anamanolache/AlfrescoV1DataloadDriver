package org.alfresco.rest.request.executor;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

public class AlfrescoV1ExecuterImpl implements RestV1Executor {
	
	protected String username;
	protected String password;
	protected RequestSpecification requestSpecification;
	
	public AlfrescoV1ExecuterImpl (String initialUsername, String initialPassword)
	{
		this.username = initialUsername;
		this.password = initialPassword;
	}
	
	@Override
	public Response executeV1Query(RequestType type, String url, String... requestBody) {
		if(requestSpecification==null)
		{
			updateAuthentication(username,password);
		}
		switch(type)
		{
		case DELETE:
			return requestSpecification.delete(url);
			
		case GET:
			return requestSpecification.get(url);

		case HEAD:
			return requestSpecification.head(url);

		case POST:
			if(requestBody==null)
			{
				return requestSpecification.post(url);
			}
			else
			{
				return requestSpecification.given().contentType("application/json").and().body(requestBody[0]).post(url);
			}

		case PUT:
			if(requestBody==null)
			{
				return requestSpecification.put(url);
			}
			else
			{
				return requestSpecification.given().contentType("application/json").and().body(requestBody[0]).put(url);
			}
		}
		return null;
	}

	@Override
	public void updateAuthentication(String username, String password) {
		requestSpecification = RestAssured.given().auth().preemptive().basic(username, password);

	}

	
}
