package org.alfresco.rest.request.file;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.alfresco.rest.request.AbstractV1Request;
import org.alfresco.rest.request.executor.RequestType;
import org.json.simple.JSONObject;

import com.jayway.restassured.response.Response;

public class FileFolderV1Request extends AbstractV1Request
{

	public void deleteNode(String nodeId)
	{
		Response response = executor.executeV1Query(RequestType.DELETE, "http://192.168.56.101:8080/alfresco/api/-default-/public/alfresco/versions/1/nodes/"+nodeId);
		response.getBody().prettyPrint();
	}
	
	public void listNodeChildren(String nodeId)
	{
		Response response = executor.executeV1Query(RequestType.GET, "http://192.168.56.101:8080/alfresco/api/-default-/public/alfresco/versions/1/nodes/"+nodeId+"/children");
		response.getBody().prettyPrint();
	}
	
	public void getNode(String nodeId)
	{
		Response response = executor.executeV1Query(RequestType.GET, "http://192.168.56.101:8080/alfresco/api/-default-/public/alfresco/versions/1/nodes/"+nodeId);
		response.getBody().prettyPrint();
	}
	
	public String createNode(String nodeId, String nodeName, String nodeType)
	{
		Map<String,Object> values = new HashMap<String,Object>();
		values.put("name", nodeName);
		values.put("nodeType", nodeType);
		new JSONObject();
		String postBody = JSONObject.toJSONString(values);
		Response response = executor.executeV1Query(RequestType.POST, "http://192.168.56.101:8080/alfresco/api/-default-/public/alfresco/versions/1/nodes/"+nodeId+"/children", postBody);
		response.getBody().prettyPrint();
		
		Map<String, Object> map = response.getBody().jsonPath().get("entry");
		return (String) map.get("id");
	}
	
	public void updateNode(String nodeId, HashMap<String,Object> properties)
	{
		new JSONObject();
		String putBody = JSONObject.toJSONString(properties);
		Response response = executor.executeV1Query(RequestType.PUT, "http://192.168.56.101:8080/alfresco/api/-default-/public/alfresco/versions/1/nodes/"+nodeId, putBody);
		response.getBody().prettyPrint();
	}
	
	public void moveNode(String nodeId, String targetId)
	{
		Map<String,Object> values = new HashMap<String,Object>();
		values.put("targetParentId", targetId);
		new JSONObject();
		String postBody = JSONObject.toJSONString(values);
		Response response = executor.executeV1Query(RequestType.POST, "http://192.168.56.101:8080/alfresco/api/-default-/public/alfresco/versions/1/nodes/"+nodeId+"/move", postBody);
		response.getBody().prettyPrint();
	}
}
