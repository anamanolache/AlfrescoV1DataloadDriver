
package org.alfresco.rest.request.executor;

import com.jayway.restassured.response.Response;

public interface RestV1Executor {

	Response executeV1Query(RequestType type, String url, String... requestBody);
	
	void updateAuthentication(String username, String password);
}
