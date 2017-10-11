package com.csi.web.weixin.exception;

import com.csi.exception.CsiException;

/**
 * Created by fanlin on 2017/10/11.
 */
public class WeixinException extends CsiException{

    private static final long serialVersionUID = -5696871042180912169L;

    private String responseCode;
    private String responseMessage;
    private Object[] placeHolders;

    public WeixinException(){}
    public WeixinException(String responseCode, Object... placeHolders){
        this.responseCode = responseCode;
        this.placeHolders = placeHolders;
    }

    public Object[] getMessageKeys() {
        return placeHolders;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public Object[] getPlaceHolders() {
        return placeHolders;
    }

    public void setPlaceHolders(Object[] placeHolders) {
        this.placeHolders = placeHolders;
    }
}
