package org.alfresco.bm.processors;

import org.alfresco.bm.event.AbstractEventProcessor;

public abstract class BaseScheduler extends AbstractEventProcessor
{
    protected String doneEventName;

    public BaseScheduler(String doneEventName)
    {
        this.doneEventName = doneEventName;
    }


}
