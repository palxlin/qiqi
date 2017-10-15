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

    public static class Weixin {

        public static final String NO_SUCH_SERVICE = "0000299";

        public static final String WRONG_PARAM_WITNESS = "0000310"; /**目击者选择线索参数错误*/
        public static final String WRONG_PARAM_JUDGE = "0000311"; /**断案参数错误*/
        public static final String WRONG_PARAM_JOIN = "0000312";
        public static final String WRONG_PARAM_CREATE_GAME = "0000313";
        public static final String WRONG_PARAM_KILL = "0000314"; /**杀人参数错误*/
        public static final String WRONG_PARAM_LOOK_ALL_PLAYER = "0000315";
        public static final String WRONG_PARAM_DETECTIVE = "0000316";

        public static final String RETURN_HELP = "0000999";

        public static final String NO_RIGHT_CREATE_GAME = "0000401"; /**没有权限创建游戏, 你可能已经在某个游戏房间中未退出*/
        public static final String NO_RIGHT_JOIN_GAME = "0000402"; /**没有权限加入游戏, 你可能已经在某个游戏房间中未退出*/
        public static final String NO_RIGHT_KILL = "0000403"; /**没有权限杀人*/
        public static final String NO_RIGHT_WITNESS = "0000404";
        public static final String NO_RIGHT_LOOK_CRIME = "0000407";
        public static final String NO_RIGHT_LOOK_ALL_PLAYER = "0000408";
        public static final String NO_RIGHT_LOOK_WITNESS = "0000410";
        public static final String NO_RIGHT_DETECTIVE = "0000411";
    }
}
