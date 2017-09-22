package org.alfresco.bm.processors;

import org.alfresco.bm.event.AbstractEventProcessor;
import org.alfresco.bm.event.Event;
import org.alfresco.bm.event.EventResult;

public class LoadFilesAndFoldersScheduler extends AbstractEventProcessor
{
    public static final String DONE_EVENT_NAME = "filesAndFoldersCreated";

    @Override
    protected EventResult processEvent(Event event) throws Exception
    {
        return Utils.schedulingDone(DONE_EVENT_NAME);
    }
}
