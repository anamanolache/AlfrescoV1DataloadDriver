package org.alfresco.rest.request.site;

import com.jayway.restassured.response.Response;
import org.alfresco.rest.request.AbstractV1Request;
import org.alfresco.rest.request.executor.RequestType;
import org.alfresco.rest.request.user.InternalBMUsers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SiteV1RequestImpl extends AbstractV1Request implements SiteV1Request
{
        @Override public List<InternalBMSite> listSites()
        {
                List<InternalBMSite> listOfSites = new ArrayList<InternalBMSite>();

                Response response = getExecutor()
                        .executeV1Query(RequestType.GET, "http://localhost:8080/alfresco/api/-default-/public/alfresco/versions/1/sites");
                //Map map = (Map)response.getBody().jsonPath().get("list/entries");
                List list = (List) ((Map) response.getBody().jsonPath().get("list//entries")).get("entries");
                for (Object obj : list)
                {
                        Map map = (Map) obj;
                        Map value = (Map) map.get("entry");
                        String shortSiteID = (String) value.get("id");
                        String siteName = (String) value.get("title");
                        InternalBMSite internalSite = new InternalBMSite();
                        internalSite.shortSiteId = shortSiteID;
                        internalSite.siteName = siteName;
                        listOfSites.add(internalSite);
                }

                return listOfSites;

        }

        @Override public boolean createSite(String shortSiteId, String siteName, String siteType)
        {

                Response response = getExecutor()
                        .executeV1Query(RequestType.POST, "http://localhost:8080/alfresco/api/-default-/public/alfresco/versions/1/sites");
                return false;
        }

        @Override public void deleteSite(String shortSiteId)
        {

        }

        @Override public void renameSite(String shortSiteId, String newName)
        {

        }

        @Override public void addMembers(Map<InternalBMUsers, String> usersWithPermissionMapping)
        {

        }

        @Override public void deleteMembers(String shortSiteID)
        {

        }

        public void createSite()
        {

        }

        public void deleteSite()
        {

        }

        public void renameSite()
        {

        }

        public void addMembers()
        {

        }

        public void deleteMembers()
        {

        }
}
