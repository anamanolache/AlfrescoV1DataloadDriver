package org.alfresco.bm.processors;

import java.util.ArrayList;
import java.util.List;

import org.alfresco.bm.event.AbstractEventProcessor;
import org.alfresco.bm.event.Event;
import org.alfresco.bm.event.EventResult;

public class Utils
{
    public static EventResult schedulingDone(String doneEventName)
    {
        List<Event> nextEvents = new ArrayList<>();
        Event doneEvent = new Event(doneEventName, null);
        nextEvents.add(doneEvent);
        return new EventResult(doneEventName, nextEvents);
    }
}
