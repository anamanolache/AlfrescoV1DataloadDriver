package org.alfresco.rest.request;

import org.alfresco.rest.request.executor.AlfrescoV1ExecuterImpl;
import org.alfresco.rest.request.executor.RestV1Executor;

public abstract class AbstractV1Request {

	public RestV1Executor executor = new AlfrescoV1ExecuterImpl("admin", "admin");
}
