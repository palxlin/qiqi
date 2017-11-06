package com.csi.util;


import org.apache.commons.lang3.StringUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Lin on 2017/11/5.
 */
public class NumberGenerator {

    private static Object MUTEX = new Object();

    private static AtomicInteger atomicInt = new AtomicInteger();

    private static char ZERO = '0';

    private static Integer LEFT_PAD = 5;

    private static Map<Integer, Integer> codeMapping = new HashMap<>();

    static {
        codeMapping.put(0, 3);
        codeMapping.put(1, 2);
        codeMapping.put(2, 5);
        codeMapping.put(3, 6);
        codeMapping.put(4, 8);
        codeMapping.put(5, 7);
        codeMapping.put(6, 1);
        codeMapping.put(7, 0);
        codeMapping.put(8, 9);
        codeMapping.put(9, 4);
    }

    private static String incrementAndGet() {

        int num = atomicInt.getAndIncrement();

        if (atomicInt.get() >= 90000) {
            synchronized (MUTEX) {
                if (atomicInt.get() >= 9000) {
                    atomicInt.set(0);
                }
            }
        }

        return StringUtils.leftPad("" + num, LEFT_PAD, ZERO);
    }

    private static String incrementAndGet2() {
        int num = atomicInt.getAndIncrement();

        if (atomicInt.get() >= 99) {
            synchronized (MUTEX) {
                if (atomicInt.get() >= 99)
                    atomicInt.set(0);
            }
        }

        return StringUtils.leftPad("" + num, 2, ZERO);
    }

    public static String generate() {
        StringBuffer sb = new StringBuffer(DateUtil.getDate(new Date(), DateUtil.DATE_FMT_YMDHMS));
        sb.append(incrementAndGet());
        return sb.toString();
    }
}
