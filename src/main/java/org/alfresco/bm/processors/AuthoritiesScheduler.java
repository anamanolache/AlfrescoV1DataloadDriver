package org.alfresco.bm.processors;

import java.util.ArrayList;
import java.util.List;

import org.alfresco.bm.event.AbstractEventProcessor;
import org.alfresco.bm.event.Event;
import org.alfresco.bm.event.EventResult;
import org.alfresco.bm.process.CreateUserProcess;

public class AuthoritiesScheduler extends AbstractEventProcessor
{
    public static final String DONE_EVENT_NAME = "authoritiesCreated";

    private int countUsers;
    private int countGroups;
    private String usernamePattern;
    private String groupNamePattern;

    public void setCountUsers(int countUsers)
    {
        this.countUsers = countUsers;
    }

    public void setCountGroups(int countGroups)
    {
        this.countGroups = countGroups;
    }

    public void setUsernamePattern(String usernamePattern)
    {
        this.usernamePattern = usernamePattern;
    }

    public void setGroupNamePattern(String groupNamePattern)
    {
        this.groupNamePattern = groupNamePattern;
    }

    @Override
    protected EventResult processEvent(Event event) throws Exception
    {
        List<Event> nextEvents = new ArrayList<>();
        for(int i=0; i< countUsers; i++)
        {
            Event createUserEvent = new Event(CreateUserProcess.CREATE_USER_EVENT, "username");
            nextEvents.add(createUserEvent);
        }
        // add done event
        Event doneEvent = new Event(DONE_EVENT_NAME, null);
        nextEvents.add(doneEvent);
        return new EventResult(DONE_EVENT_NAME, nextEvents);
    }
}
