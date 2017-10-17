package com.csi.web.weixin.reply;

import com.csi.web.weixin.reply.detail.MediaDetail;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by fanlin on 2017/10/17.
 */
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImageReply extends Reply{
    @XmlElement(name = "Image")
    private MediaDetail imageDetail;

    public MediaDetail getImageDetail() {
        return imageDetail;
    }

    public void setImageDetail(MediaDetail imageDetail) {
        this.imageDetail = imageDetail;
    }
}
