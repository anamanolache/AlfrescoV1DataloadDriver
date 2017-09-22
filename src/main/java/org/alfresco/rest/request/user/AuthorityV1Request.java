package org.alfresco.rest.request.user;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;

import com.jayway.restassured.response.Response;
import org.alfresco.rest.request.AbstractV1Request;
import org.alfresco.rest.request.executor.RequestType;

public class AuthorityV1Request extends AbstractV1Request
{

	public void createUser(String username, String password)
	{
		String putBody;
		Map<String,Object> values = new HashMap<String,Object>();
		values.put("id", username);
		values.put("firstName", username);
		values.put("email", username+"@alfresco.com");
		values.put("enabled", "true");
		values.put("password", password);
		new JSONObject();
		putBody= JSONObject.toJSONString(values);
		Response newusers = executor.executeV1Query(RequestType.POST, "http://192.168.56.101:8080/alfresco/api/-default-/public/alfresco/versions/1/people", putBody);
		newusers.getBody().prettyPrint();
	}
	
	public void listUsers()
	{
		Response users = executor.executeV1Query(RequestType.GET, "http://192.168.56.101:8080/alfresco/api/-default-/public/alfresco/versions/1/people");
		System.out.println(users.getBody().prettyPrint());
	}
}
