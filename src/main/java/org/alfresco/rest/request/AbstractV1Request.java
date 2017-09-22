package org.alfresco.rest.request;

import org.alfresco.rest.request.executor.AlfrescoV1ExecuterImpl;
import org.alfresco.rest.request.executor.RestV1Executor;

public abstract class AbstractV1Request
{
	protected String serverAddres;
	protected String v1Path;
	protected String endpointName;
	public RestV1Executor executor = new AlfrescoV1ExecuterImpl("admin", "admin");

	public void setServerAddres(String serverAddres)
	{
		this.serverAddres = serverAddres;
	}

	public void setV1Path(String v1Path)
	{
		this.v1Path = v1Path;
	}

	public void setEndpointName(String endpointName)
	{
		this.endpointName = endpointName;
	}

	public String getURL()
	{
		return serverAddres + "/" + v1Path + "/" + endpointName;
	}
}
