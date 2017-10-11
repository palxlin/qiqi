package com.csi.web.weixin.exception;

import com.csi.web.constants.CodeMapping;
import com.csi.web.weixin.receive.Message;
import com.csi.web.weixin.reply.Reply;
import com.csi.web.weixin.util.ReplyUtil;

import java.text.MessageFormat;
import java.util.ResourceBundle;

/**
 * Created by fanlin on 2017/10/11.
 */
public class ResponseCodeHelper {

    public static Reply parseMessage(Message message, WeixinException e) {

        String respCode = CodeMapping.getMappingCode(e.getResponseCode());

        String msg = getMessage(respCode, e.getResponseCode(), e.getMessageKeys());

        return ReplyUtil.buildTextReply(msg, message);
    }

    private static String getMessage(String mappedCode, String responseCode, Object... messageKeys) {

        String msg = getMsg(mappedCode);

        if (messageKeys != null) {
            msg = MessageFormat.format(msg, messageKeys);
        }

        return buildMsg(msg, responseCode);
    }

    private static String buildMsg(String msg, String code) {

        StringBuilder sb = new StringBuilder(msg);
        sb.append("[").append(code).append("]");

        return sb.toString();
    }

    private static final String getMsg(String mappedCode) {
        return ResourceBundle.getBundle("responsecodes").getString(mappedCode);
    }
}
