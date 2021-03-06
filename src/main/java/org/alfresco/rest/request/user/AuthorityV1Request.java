package org.alfresco.rest.request.user;

import java.util.HashMap;
import java.util.Map;

import com.jayway.restassured.response.Response;

import org.alfresco.rest.request.AbstractV1Request;
import org.alfresco.rest.request.executor.RequestType;
import org.json.simple.JSONObject;

public class AuthorityV1Request extends AbstractV1Request
{

	public void createUser(String username, String password)
	{
		String postBody = createUserJSON(username, password);

		Response newusers = getExecutor().executeV1Query(RequestType.POST, getURL(), postBody);
		newusers.getBody().prettyPrint();
	}
	
	public void listUsers()
	{
		Response users = getExecutor().executeV1Query(RequestType.GET, getURL());
		System.out.println(users.getBody().prettyPrint());
	}
	
	public String createUserJSON(String username, String password)
	{
		Map<String,Object> values = new HashMap<String,Object>();
		values.put("id", username);
		values.put("firstName", username);
		values.put("email", username+"@alfresco.com");
		values.put("enabled", "true");
		values.put("password", password);
		new JSONObject();
		return JSONObject.toJSONString(values);
	}
}
