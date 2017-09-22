package org.alfresco.bm.processors;

import java.util.ArrayList;
import java.util.List;

import org.alfresco.bm.event.AbstractEventProcessor;
import org.alfresco.bm.event.Event;
import org.alfresco.bm.event.EventResult;

public abstract class BaseScheduler extends AbstractEventProcessor
{
    protected String doneEventName;

    public BaseScheduler(String doneEventName)
    {
        this.doneEventName = doneEventName;
    }

    protected EventResult schedulingDone()
    {
        List<Event> nextEvents = new ArrayList<>();
        Event doneEvent = new Event(doneEventName, null);
        nextEvents.add(doneEvent);
        return new EventResult(doneEventName, nextEvents);
    }
}
