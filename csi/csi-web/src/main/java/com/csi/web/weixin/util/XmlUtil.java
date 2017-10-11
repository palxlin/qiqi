package com.csi.web.weixin.util;

import com.csi.web.weixin.receive.Message;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

/**
 * Created by fanlin on 2017/10/11.
 */
public class XmlUtil {

    public static Message unmarchal(String message, Class<? extends Message> childClass){
        try{
            JAXBContext jaxbContext = JAXBContext.newInstance(Message.class, childClass);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            return (Message) unmarshaller.unmarshal(new StringReader(message));
        } catch (Exception e) {

        }

        return null;
    }

}
