package com.csi.web.weixin.exception;

/**
 * Created by fanlin on 2017/10/11.
 */
public class ResponseCode {


    public class Sys {

        public static final String PARAM_ILLEGAL = "0000001";

        public static final String SYS_ERR = "0000002";

        public static final String AUTH_FAILED = "0000003";

        public static final String AUTH_TIME_EXPIRED = "0000004";

        public static final String AUTH_COUNT_EXCEED = "0000005";
    }

    public class Weixin {

        public static final String NO_SUCH_SERVICE = "0000209";

    }
}
