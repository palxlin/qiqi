package com.csi.web.system;

import com.csi.model.system.Config;
import com.csi.system.SystemConfig;
import com.csi.model.weixin.WeixinAppInfo;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by fanlin on 2017/10/17.
 */
public class AdminConfig extends SystemConfig implements ApplicationListener<ContextRefreshedEvent>{

    private Integer systemId;

    private static Map<String, String> inMemoryConfig = new HashMap<String, String>();

    private static Map<String, WeixinAppInfo> appInfoMap = new HashMap<String, WeixinAppInfo>();

    private static String staticContextPath;

    private static String staticResourcePath;

    public static String KEY_ACCESS_TOKEN_MAX_COUNT = "access_token_max_count";

    public static String KEY_ACCESS_TOKEN_TIMEOUT = "access_token_timeout";

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        if (event.getApplicationContext().getParent() == null) {

            if (event instanceof ContextRefreshedEvent) {

                staticContextPath = getContextPath();

                doLoad();

                authTokenService.initSessionMap();

                try {

                    if (!isOnTestMode()) {

                        weixinConfig.reloadAccessToken();

                        weixinConfig.reloadMenu();
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        }
    }


    public void doLoad() {

        List<Config> configs = configService.refresh(systemId);

        Map<String, String> inMemoryConfigTemp = new HashMap<String, String>();
        for (Config config : configs) {

            inMemoryConfigTemp.put(config.getKey(), config.getValue());

        }

        inMemoryConfig = inMemoryConfigTemp;

    }

    public Integer getSystemId() {
        return systemId;
    }

    public void setSystemId(Integer systemId) {
        this.systemId = systemId;
    }

    public static String get(String key) {
        return inMemoryConfig.get(key);
    }

    public static Integer getInt(String key) {
        String tmp = inMemoryConfig.get(key);
        if (tmp == null) {
            tmp = "0";
        }
        return Integer.valueOf(tmp);
    }

    public static void setInt(String key, String value) {
        inMemoryConfig.put(key, value);
    }

    public static WeixinAppInfo getAppInfo(String appId) {
        return appInfoMap.get(appId);
    }

    public static void refresh(List<Config> configs) {

        Map<String, String> temp = new HashMap<String, String>();

        for (Config config : configs) {

            temp.put(config.getKey(), config.getValue());

        }

        inMemoryConfig = temp;

    }
}
