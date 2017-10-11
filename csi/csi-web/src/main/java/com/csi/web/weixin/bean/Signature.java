package com.csi.web.weixin.bean;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by fanlin on 2017/10/10.
 */
public class Signature {

    private String token = "c5b595e847281f11452afbb53f80dfd7";
    private String signature;
    private String timestamp;
    private String nonce;
    private String echostr;

    public static Signature createSignatureByHttpRequest(HttpServletRequest request){

        Signature signature = new Signature();
        signature.signature = request.getParameter("signature");
        signature.timestamp = request.getParameter("timestamp");
        signature.nonce = request.getParameter("nonce");
        signature.echostr = request.getParameter("echostr");

        return signature;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public String getEchostr() {
        return echostr;
    }

    public void setEchostr(String echostr) {
        this.echostr = echostr;
    }

    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SIMPLE_STYLE);
    }
}
