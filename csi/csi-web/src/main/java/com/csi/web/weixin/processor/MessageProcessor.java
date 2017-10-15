package com.csi.web.weixin.processor;

import com.csi.web.weixin.exception.ResponseCode;
import com.csi.web.weixin.exception.WeixinException;
import com.csi.web.weixin.handler.Handler;
import com.csi.web.weixin.receive.Message;
import com.csi.web.weixin.reply.Reply;
import com.csi.web.weixin.util.WeixinUtil;
import com.csi.web.weixin.util.XmlUtil;
import com.csi.web.weixin.exception.ResponseCodeHelper;
import org.apache.commons.lang3.EnumUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

/**
 * Created by fanlin on 2017/10/11.
 */
public abstract class MessageProcessor {

    private static final Logger logger = LoggerFactory.getLogger(MessageProcessor.class);

    protected Message message;

    public MessageProcessor(String messgae, Class<? extends Message> messageClass){
        this.message = XmlUtil.unmarchal(messgae, messageClass);
    }

    public Reply process() {

        try {

            Reply reply = getEventHandler().handleEvent(this.message);

            return reply;

        } catch (WeixinException e){
            Reply reply = ResponseCodeHelper.parseMessage(this.message, e);
//            logger.warn(JsonUtil.toJson(reply));

            if(ResponseCode.Weixin.NO_SUCH_SERVICE.equals(e.getResponseCode())) {
                e.setResponseCode(ResponseCode.Weixin.RETURN_HELP);
                return ResponseCodeHelper.parseMessage(this.message, e);
            }
            return reply;
        }
    }

    public abstract Handler getEventHandler() throws WeixinException;

    public static MessageProcessor getMessageProcessor(String message) throws WeixinException {

        String messageType = WeixinUtil.getMsgType(message);
        if (StringUtils.isEmpty(messageType)){
            throw new WeixinException(ResponseCode.Weixin.NO_SUCH_SERVICE);
        }

        MessageProcessorFactory messageProcessorFactory = EnumUtils.getEnum(MessageProcessorFactory.class, StringUtils.upperCase(messageType));

        if(messageProcessorFactory == null){
            throw new WeixinException(ResponseCode.Weixin.NO_SUCH_SERVICE);
        }

        MessageProcessor processor = messageProcessorFactory.createProcessor(message);

        return processor;
    }
}
