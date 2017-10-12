package com.csi.web.weixin.handler;

import com.csi.web.weixin.receive.Message;
import com.csi.web.weixin.reply.Reply;
import com.csi.web.weixin.exception.WeixinException;

/**
 * Created by fanlin on 2017/10/11.
 */
public abstract class Handler {

    private String messageTemplate;
    private String eventKey;

    public abstract Reply handleEvent(Message message) throws WeixinException;

    public String getMessageTemplate() {
        return messageTemplate;
    }

    public void setMessageTemplate(String messageTemplate) {
        this.messageTemplate = messageTemplate;
    }

    public String getEventKey() {
        return eventKey;
    }

    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }
}
