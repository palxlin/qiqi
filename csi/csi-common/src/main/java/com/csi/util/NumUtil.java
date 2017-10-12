package com.csi.util;

import java.util.Random;

/**
 * Created by fanlin on 2017/10/12.
 */
public class NumUtil {

    public static int generate4Nums(){
        return new Random().nextInt(9000) + 1000;
    }
}
