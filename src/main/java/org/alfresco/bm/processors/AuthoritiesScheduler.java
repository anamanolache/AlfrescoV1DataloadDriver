package org.alfresco.bm.processors;

import java.util.ArrayList;
import java.util.List;

import org.alfresco.bm.event.AbstractEventProcessor;
import org.alfresco.bm.event.Event;
import org.alfresco.bm.event.EventResult;

public class AuthoritiesScheduler extends BaseScheduler
{
    private int countUsers;
    private int countGroups;
    private String usernamePattern;
    private String groupNamePattern;

    public AuthoritiesScheduler(String doneEventName)
    {
        super(doneEventName);
    }

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
        List<Event> events = new ArrayList<>();
        for(int i=0; i< countUsers; i++)
        {

        }
        return schedulingDone();
    }
}
