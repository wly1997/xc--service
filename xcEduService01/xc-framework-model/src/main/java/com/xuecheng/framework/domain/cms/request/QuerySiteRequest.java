package com.xuecheng.framework.domain.cms.request;

import org.apache.http.protocol.RequestDate;

public class QuerySiteRequest extends RequestDate {
    private String siteId;
    //站点名称
    private String siteName;
    //站点地址
    private String siteDomain;

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getSiteDomain() {
        return siteDomain;
    }

    public void setSiteDomain(String siteDomain) {
        this.siteDomain = siteDomain;
    }
}
