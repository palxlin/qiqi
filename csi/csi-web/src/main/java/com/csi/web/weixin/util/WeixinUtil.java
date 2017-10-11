package com.csi.web.weixin.util;

import com.google.common.base.Charsets;
import com.csi.web.weixin.bean.Signature;
import com.google.common.hash.Hashing;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Created by fanlin on 2017/10/10.
 */
public class WeixinUtil {

    private static final Logger logger = LoggerFactory.getLogger(WeixinUtil.class);

    public static boolean checkSignature(Signature signature) throws InvocationTargetException{
        String sign = Hashing.sha1().hashString(buildSignatureText(signature), Charsets.UTF_8).toString();

        logger.warn("computed signature : {}", sign);

        return sign.equalsIgnoreCase(signature.getSignature());
    }

    private static String buildSignatureText(Signature signature) {
        List<String> list = new ArrayList<String>();
        list.add(Validate.notNull(signature.getToken(), "miss-token"));
        list.add(Validate.notNull(signature.getTimestamp(), "miss-timestamp"));
        list.add(Validate.notNull(signature.getNonce(), "miss-nonce"));
        Collections.sort(list);

        return StringUtils.join(list, "");


    }
}
