package com.csi.web.weixin.processor;

import com.csi.web.weixin.receive.TextMessage;

/**
 * Created by fanlin on 2017/10/12.
 */
public enum MessageProcessorFactory {

    TEXT {
        @Override
        public MessageProcessor createProcessor(String message) {
            return new TextProcessor(message, TextMessage.class);
        }
    };

    public abstract MessageProcessor createProcessor(String message);
}
