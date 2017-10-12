package com.csi.web.controller.weixin;

import com.csi.web.weixin.bean.Signature;
import com.csi.web.weixin.processor.MessageProcessor;
import com.csi.web.weixin.util.WeixinUtil;
import com.csi.web.weixin.reply.Reply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by fanlin on 2017/10/10.
 */
@Controller
@RequestMapping(value = "weixin")
public class WeixinController {

    private static final Logger logger = LoggerFactory.getLogger(WeixinController.class);

    @RequestMapping(value = "entry", method = RequestMethod.GET)
    @ResponseBody
    public String handleEntry(HttpServletRequest request) {
        try {
            Signature signature = Signature.createSignatureByHttpRequest(request);

            logger.warn("signature: {}", signature.toString());

            boolean hasRights = WeixinUtil.checkSignature(signature);
            if (!hasRights) {
                logger.warn("signature check failed:{}", signature);
            }
            logger.warn("weixin entry success");

            return signature.getEchostr();

        } catch (InvocationTargetException e) {

            logger.error("signature-error", e);
        }
        return null;
    }

    @RequestMapping(value = "entry", method = RequestMethod.POST, produces = "application/xml;charset=UTF-8")
    @ResponseBody
    public Reply handleWeixinEntry(@RequestBody String message){
        try {
            logger.warn("request message : \n{}", message);

            MessageProcessor weixinProcessor = MessageProcessor.getMessageProcessor(message);

            Reply reply = weixinProcessor.process();

            logger.warn("reply message : \n{}", reply);

            return reply;
        } catch (Exception e) {

            logger.error("unhandled exception", e);
        }

        return null;
    }
//
//    @RequestMapping(value = "process", method = RequestMethod.POST, produces = "application/xml;charset=UTF-8")
//    @ResponseBody
//    public Reply handleWeixin(@RequestBody String message){
//        try {
//            logger.warn("request message : {} ", message);
//
//            MessageProcessor weixinProcessor = MessageProcessor.getMessageProcessor(message);
//
//            return weixinProcessor.process();
//        } catch (Exception e) {
//
//            logger.error("unhandled exception", e);
//        }
//
//        return null;
//    }

}
