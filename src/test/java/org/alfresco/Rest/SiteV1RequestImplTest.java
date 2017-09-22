package org.alfresco.Rest;

import org.alfresco.rest.request.site.SiteV1Request;
import org.alfresco.rest.request.site.SiteV1RequestImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class SiteV1RequestImplTest
{
        SiteV1Request siteV1Request;
        @Before
        public void setup()
        {
                siteV1Request  = new SiteV1RequestImpl();
        }
        @Test
        public void testListSites()
        {
                assertTrue("At least on site should be there.", siteV1Request.listSites().size() > 0);

        }
}
