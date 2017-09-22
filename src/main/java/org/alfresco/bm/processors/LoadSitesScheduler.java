package org.alfresco.bm.processors;

import org.alfresco.bm.event.Event;
import org.alfresco.bm.event.EventResult;
import org.alfresco.rest.request.site.SiteV1RequestImpl;

public class LoadSitesScheduler extends BaseScheduler
{

    public LoadSitesScheduler(String doneEventName)
    {
        super(doneEventName);
    }

    @Override
    protected EventResult processEvent(Event event) throws Exception
    {

        SiteV1RequestImpl siteV1Request = new SiteV1RequestImpl();
        siteV1Request.listSites();
        

        return schedulingDone();
    }
}
