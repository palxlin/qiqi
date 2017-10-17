package com.csi.model.constants.enums;

/**
 * Created by fanlin on 2017/10/16.
 */
public enum DetectiveStatusEnum {

    NORMAL(0, "正常"),
    FAIL(1, "断案失败，失去机会"),
    EXIT(99, "已退出游戏"),
    FINISH(3, "游戏结束，自动退出游戏");

    private Integer id;
    private String name;

    DetectiveStatusEnum(Integer id, String name){
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
