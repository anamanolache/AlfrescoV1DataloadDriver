package org.alfresco.rest.request;

public abstract class AbstractV1Request {

	RestV1Executor executor = new AlfrescoV1ExecuterImpl("admin", "admin");
}
