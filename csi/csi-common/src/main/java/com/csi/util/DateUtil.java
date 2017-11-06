package com.csi.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Lin on 2017/11/5.
 */
public class DateUtil {

    public static final String FORMAT_FOR_APP = "yyyyMMdd HH:mm:ss";

    public static final String DATE_FMT_YMDHMS = "yyyyMMddHHmmss";

    public static String getDate(Date date, String format) {
        return new SimpleDateFormat(format).format(date);
    }
}
