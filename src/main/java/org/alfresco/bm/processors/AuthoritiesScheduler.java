package org.alfresco.bm.processors;

import java.util.ArrayList;
import java.util.List;

import org.alfresco.bm.event.AbstractEventProcessor;
import org.alfresco.bm.event.Event;
import org.alfresco.bm.event.EventResult;

public class AuthoritiesScheduler extends BaseScheduler
{
    public AuthoritiesScheduler(String doneEventName)
    {
        super(doneEventName);
    }

    @Override
    protected EventResult processEvent(Event event) throws Exception
    {
        return schedulingDone();
    }
}
