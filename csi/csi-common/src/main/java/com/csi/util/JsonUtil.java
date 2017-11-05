package com.csi.util;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;

/**
 * Created by Lin on 2017/11/5.
 */
public class JsonUtil {

    private static final Logger logger = LoggerFactory.getLogger(JsonUtil.class);

    private static final ObjectMapper mapper = new ObjectMapper();

    public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static final String EMPTY_JSON = "{}";
    public static final byte[] EMPTY_JSON_BYTES = new byte[]{'{', '}'};

    static {

        mapper.configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS, false);
        mapper.configure(SerializationConfig.Feature.INDENT_OUTPUT, false);
        mapper.getSerializationConfig().setDateFormat(new SimpleDateFormat(DATE_FORMAT));
    }

    public static <T> T fromJson(String json, Class<T> t){
        if (json == null)
            return null;
        try{
            return mapper.readValue(json, t);
        } catch (Exception e){
            logger.info("cannot parse json to Ojbect. Json: [" + json + "], Object class: [" + t.getName() + "]", e);
        }
        return null;
    }

    public static String toJson(Object obj){
        try{
            return mapper.writeValueAsString(obj);
        } catch (Exception e){
            logger.warn("cannot write object to Json", e);;
        }
        return EMPTY_JSON;
    }
}
