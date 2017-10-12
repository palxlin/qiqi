package com.csi.web.weixin.constants;

/**
 * Created by fanlin on 2017/10/12.
 */
public enum TextKeyEnum {

    H(1, "help"),
    C(2, "create"),
    J(3, "join");

    private Integer key;
    private String name;

    TextKeyEnum(Integer key, String name) {
        this.key = key;
        this.name = name;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
