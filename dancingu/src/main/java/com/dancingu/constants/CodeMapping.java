package com.dancingu.constants;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * Created by fanlin on 2017/10/11.
 */
public class CodeMapping {

    private static final String FILE_NAME = "config/business/codemapping.properties";

    // A7代表未捕获异常
    private static final String DEFAULT_RESP = "A7";

    private static Map<String, String> codeMapping = new HashMap<String, String>();

    static {

        init();

    }

    private CodeMapping() {
    }

    /**
     * 始终返回值，默认01
     */
    public static String getMappingCode(String innerErrorCode) {

        String resp = codeMapping.get(innerErrorCode);

        return resp;
    }

    private static void init() {

        InputStream in = CodeMapping.class.getResourceAsStream("/" + FILE_NAME);

        Properties props = new Properties();
        try {
            props.load(in);
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }

        Set<Map.Entry<Object, Object>> entries = props.entrySet();
        for (Map.Entry<Object, Object> entry : entries) {
            String codes = (String) entry.getValue();
            String key = (String) entry.getKey();
            String[] codesArr = codes.split(",");
            for (String code : codesArr) {
                codeMapping.put(code, key);
            }
        }
    }
}
