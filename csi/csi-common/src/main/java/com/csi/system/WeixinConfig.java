package com.csi.system;

import com.csi.constants.Constants;
import com.csi.constants.WeixinConstans;
import com.csi.util.FileUtil;
import com.csi.util.HttpUtil;
import com.csi.util.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;

import java.text.MessageFormat;
import java.util.Map;

/**
 * Created by Lin on 2017/11/4.
 */
public class WeixinConfig extends SystemConfig implements InitializingBean{

    private static final Logger logger = LoggerFactory.getLogger(WeixinConfig.class);

    public static int ACCESS_TOKEN_TIMEOUT = 60;
    public static int ACCESS_TOKEN_MAX_COUNT = 20;

    private String menuJson;
    private String accessToken;
    private Integer expiredIn;
    private String token;
    private String appId;
    private String appSecret;
    private String ticket;

    @Override
    public void afterPropertiesSet() throws Exception {

        loadFromFile();
    }

    private void loadFromFile() {

        setMenuJson(FileUtil.loadFileAsString(getFilePath() + "/" + WeixinConstans.MENU_FILE_NAME));
    }

    public void reloadAccessToken() throws Exception{

        String url = getWeixinAccessTokenUrl();

        logger.warn("[accessTokenRequest: {}]", WeixinConstans.URL_TOKEN);

        String result = HttpUtil.get(url, Constants.DFT_SYS_ENCODING);

        logger.warn("[accessTokenResponse: {}]", result);

        Map<String, Object> accessResponse = JsonUtil.fromJson(result, Map.class);

        setExpiredIn((Integer) accessResponse.get("expires_in"));
        setAccessToken((String) accessResponse.get("access_token"));

        String ticketUrl = MessageFormat.format(WeixinConstans.URL_TICKET, getAccessToken());

        String ticketResult = HttpUtil.get(ticketUrl, Constants.DFT_SYS_ENCODING);

        Map<String, Object> ticketResponse = JsonUtil.fromJson(ticketResult, Map.class);

        setTicket((String) ticketResponse.get("ticket"));

        logger.warn("ticketResponse: {}", ticketResult);
        logger.warn("ticket: {}", getTicket());
    }

    public void reloadMenu() throws Exception {
        String url = getWeinxinMenuUrl();

        logger.warn("menu url: {}", url);

        String result = HttpUtil.post(url, getMenuJson());

        logger.warn("post menu url {}", result);
    }

    public String getWeinxinMenuUrl() {
        return MessageFormat.format(WeixinConstans.URL_MENU_CREATE, accessToken);
    }

    private String getWeixinAccessTokenUrl() {
        return MessageFormat.format(WeixinConstans.URL_MENU_CREATE, appId, appSecret);
    }

    public static Logger getLogger() {
        return logger;
    }

    public String getMenuJson() {
        return menuJson;
    }

    public void setMenuJson(String menuJson) {
        this.menuJson = menuJson;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Integer getExpiredIn() {
        return expiredIn;
    }

    public void setExpiredIn(Integer expiredIn) {
        this.expiredIn = expiredIn;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }
}
