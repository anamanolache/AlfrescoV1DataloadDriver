package org.alfresco.rest.request.site;

import org.alfresco.rest.request.user.InternalBMUsers;

import java.util.List;
import java.util.Map;

public interface SiteV1Request
{
        List<InternalBMSite> listSites();

        boolean createSite(String shortSiteId, String siteName, String siteType);

        void deleteSite(String shortSiteId);

        void renameSite(String shortSiteId, String newName);

        void addMembers(Map<InternalBMUsers,String> usersWithPermissionMapping);

        void deleteMembers(String shortSiteID);

}