package org.alfresco.bm.processors;

import org.alfresco.bm.event.AbstractEventProcessor;
import org.alfresco.bm.event.Event;
import org.alfresco.bm.event.EventResult;
import org.alfresco.rest.request.site.SiteV1RequestImpl;

public class LoadSitesScheduler extends AbstractEventProcessor
{
    public static final String DONE_EVENT_NAME = "sitesCreated";

    @Override
    protected EventResult processEvent(Event event) throws Exception
    {

        SiteV1RequestImpl siteV1Request = new SiteV1RequestImpl();
        siteV1Request.listSites();


        return new EventResult("done", new Event(DONE_EVENT_NAME, null));
    }
}
