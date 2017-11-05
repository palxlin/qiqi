package com.csi.service.weixin;

import com.csi.exception.AccessCountExceedException;
import com.csi.exception.AccessTimeoutException;
import com.csi.map.MaintainableMap;
import com.csi.model.weixin.AccessToken;
import com.csi.model.weixin.WeixinAppInfo;
import com.csi.system.WeixinConfig;
import com.csi.util.NumberGenerator;
import org.springframework.stereotype.Service;

/**
 * Created by fanlin on 2017/10/17.
 */

@Service
public class AuthTokenService {

    private MaintainableMap<String, AccessToken> accessTokenMap;

    /**
     * session 超时的时间，分钟
     */
    private int sessionTimeout = 120;

    /**
     * session id的缓存大小，实际不限制，影响清理缓存的频度
     */
    private int sessionMapSize = 50000;


    private int maxAccessCount = 7200;


    public void initSessionMap() {
        accessTokenMap = new MaintainableMap<String, AccessToken>(sessionMapSize, 0.7f, WeixinConfig.ACCESS_TOKEN_TIMEOUT * 60 * 10, WeixinConfig.ACCESS_TOKEN_MAX_COUNT + 1);
    }

    public AccessToken getAccessToken(String accessToken) throws AccessTimeoutException, AccessCountExceedException {

        return accessTokenMap.get(accessToken);

    }

    public AccessToken getAccessTokenSilence(String accessToken) {

        try {
            return accessTokenMap.get(accessToken);
        } catch (AccessTimeoutException e) {
        } catch (AccessCountExceedException e) {
        }
        return null;
    }

    public void setAccessToken(String vid, AccessToken appContext) {
        accessTokenMap.put(vid, appContext);
    }

    public AccessToken generate(WeixinAppInfo appInfo) {

        String token = NumberGenerator.generate();

        AccessToken accessToken = new AccessToken(token, appInfo);

        accessTokenMap.put(token, accessToken);

        try {

            return accessTokenMap.get(token);

        } catch (AccessTimeoutException e) {

        } catch (AccessCountExceedException e) {

        }

        return accessToken;
    }
}
