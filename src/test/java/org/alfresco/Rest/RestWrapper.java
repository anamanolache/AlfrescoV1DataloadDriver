package org.alfresco.Rest;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.alfresco.rest.request.file.FileFolderV1Request;
import org.alfresco.rest.request.user.AuthorityV1Request;
import org.junit.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

public class RestWrapper {
	AuthorityV1Request authority = new AuthorityV1Request();
	FileFolderV1Request fileFolder = new FileFolderV1Request();

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
		authority.listUsers();
	}
	
	@Test
	public void createUsers()
	{
		authority.createUser("userA"+UUID.randomUUID(), "password");
	}
	
	@Test
	public void fileFolderTest()
	{
		fileFolder.getNode("-my-");
		String folderName = "folder"+UUID.randomUUID();
		String fileName = "file"+UUID.randomUUID();
		String folderId = fileFolder.createNode("-my-", folderName, "cm:folder");
		String fileId = fileFolder.createNode("-my-", fileName, "cm:content");
		fileFolder.listNodeChildren("-my-");
		
		HashMap<String,Object> properties = new HashMap<String,Object>();
		properties.put("name", "newName"+UUID.randomUUID());
		fileFolder.updateNode(fileId, properties);
		//fileFolder.getNode(fileId);
		
		fileFolder.deleteNode(folderId);
	}
}
