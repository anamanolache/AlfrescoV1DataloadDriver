package org.alfresco.bm.process;

import org.alfresco.bm.event.AbstractEventProcessor;
import org.alfresco.bm.event.Event;
import org.alfresco.bm.event.EventResult;
import org.alfresco.bm.processors.Utils;
import org.alfresco.rest.request.user.AuthorityV1Request;

public class CreateUserProcess extends AbstractEventProcessor
{
    public static final String CREATE_USER_EVENT = "createUser";
    public static final String DONE_EVENT_NAME = "userCreated";

    private AuthorityV1Request api;

    public void setApi(AuthorityV1Request api)
    {
        this.api = api;
    }

    @Override
    protected EventResult processEvent(Event event) throws Exception
    {
        api.listUsers();
        return Utils.schedulingDone(DONE_EVENT_NAME);
    }
}
