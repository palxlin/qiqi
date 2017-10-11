package com.csi.web.weixin.reply;

import javax.xml.bind.annotation.*;

/**
 * Created by fanlin on 2017/10/11.
 */
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class TextReply extends Reply {

    @XmlElement(name = "Content")
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
