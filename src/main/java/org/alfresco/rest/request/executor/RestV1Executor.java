package org.alfresco.rest.request.executor;
import com.jayway.restassured.response.*;

public interface RestV1Executor {

	Response executeV1Query(RequestType type, String url);
	
	void updateAuthentication(String username, String password);
}
