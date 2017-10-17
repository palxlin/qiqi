package com.csi.service.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fanlin on 2017/10/16.
 */
public class ParamUtils {

    public static String[] parseParam(String param) {

        String[] params = param.trim().split(" ");

        List<String> res = new ArrayList<>();
        for (int i = 0; i < params.length; i++) {
            if (!params[i].equals(""))
                res.add(params[i]);
        }

        String[] result = new String[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = (String) res.get(i);
        }

        return result;
    }

}
