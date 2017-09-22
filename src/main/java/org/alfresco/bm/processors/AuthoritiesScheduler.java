package org.alfresco.bm.processors;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

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

    private int scheduledUsers = 0;
    private int scheduleDelay = 5000;

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
        List<Event> nextEvents = new LinkedList<>();
        if(scheduledUsers < countUsers)
        {
            for (int i = 0; i < countUsers; i++)
            {
                Event createUserEvent = new Event(CreateUserProcess.CREATE_USER_EVENT, usernamePattern.replace("%", UUID.randomUUID().toString().substring(0, 8)));
                nextEvents.add(createUserEvent);
            }
            scheduledUsers += countUsers;

            // reschedule self
            Event rescheduleEvent = new Event(event.getName(), scheduleDelay, null);
            nextEvents.add(rescheduleEvent);

            return new EventResult("Raised " + nextEvents.size() + " jobs. Reschedule self.", nextEvents);
        }
        else
        {
            // no more work to do,  raise done event
            return new EventResult("done", new Event(DONE_EVENT_NAME, null));
        }
    }
}
