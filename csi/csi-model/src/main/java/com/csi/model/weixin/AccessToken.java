package com.csi.model.weixin;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Created by fanlin on 2017/10/17.
 */
public class AccessToken {

    @JsonProperty("accessToken")
    private String token;
    @JsonIgnore
    private WeixinAppInfo appInfo;

    public AccessToken(String token, WeixinAppInfo appInfo) {
        this.token = token;
        this.appInfo = appInfo;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public WeixinAppInfo getWeixinAppInfo() {
        return appInfo;
    }

    public void setWeixinAppInfo(WeixinAppInfo appInfo) {
        this.appInfo = appInfo;
    }
}
