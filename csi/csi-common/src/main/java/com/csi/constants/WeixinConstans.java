package com.csi.constants;

/**
 * Created by Lin on 2017/11/5.
 */
public class WeixinConstans {

    public static final String URL_TOKEN = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid={0}&secret={1}";
    public static final String URL_MENU_CREATE = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token={0}";
    public static final String URL_TICKET = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_toekn={0}&type=jsapi";

    public static final String MENU_FILE_NAME = "weixinMenu.json";
}
