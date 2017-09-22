package org.alfresco.rest.request;

import org.alfresco.rest.request.executor.AlfrescoV1ExecuterImpl;
import org.alfresco.rest.request.executor.RestV1Executor;
import org.alfresco.rest.request.user.AuthorityV1Request;
import org.springframework.context.ApplicationContext;

public abstract class AbstractV1Request
{
	protected String serverAddres;
	protected String v1Path;
	protected String endpointName;
	//private RestV1Executor executor = new AlfrescoV1ExecuterImpl("admin", "admin");
	private ApplicationContext applicationContext;

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

	public void setApplicationContext(ApplicationContext applicationContext)
	{
		this.applicationContext = applicationContext;
	}

	public String getURL()
	{
		return serverAddres + "/" + v1Path + "/" + endpointName;
	}

	protected RestV1Executor getExecutor()
	{
		return new AlfrescoV1ExecuterImpl("admin", "admin");
	}
}
