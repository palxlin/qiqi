package com.csi.web.weixin.processor;

import com.csi.service.utils.ParamUtils;
import com.csi.web.weixin.constants.TextKeyEnum;
import com.csi.web.weixin.exception.WeixinException;
import com.csi.web.weixin.handler.Handler;
import com.csi.web.weixin.receive.TextMessage;
import com.csi.web.weixin.util.ServiceStaticAccess;
import com.csi.web.weixin.exception.ResponseCode;
import org.apache.commons.lang3.EnumUtils;

/**
 * Created by fanlin on 2017/10/12.
 */
public class TextProcessor extends MessageProcessor {

    public TextProcessor(String message, Class<TextMessage> textMessageClass) {
        super(message, textMessageClass);
    }

    @Override
    public Handler getEventHandler() throws WeixinException {

        TextMessage textMessage = (TextMessage)message;

        TextKeyEnum textKeyEnum = processContent(textMessage.getContent());

        Handler handler = ServiceStaticAccess.getBean(textKeyEnum.getName() + "Handler", Handler.class);

        if (handler == null) {

            throw new WeixinException(ResponseCode.Weixin.NO_SUCH_SERVICE);
        }

        return handler;
    }

    public TextKeyEnum processContent(String message) {

        String[] contents = ParamUtils.parseParam(message);

        TextKeyEnum textKeyEnum = EnumUtils.getEnum(TextKeyEnum.class, contents[0].toUpperCase());

        if(textKeyEnum == null)
            return TextKeyEnum.H;

        return textKeyEnum;
    }
}
