package com.csi.model.constants.enums;

/**
 * Created by fanlin on 2017/10/14.
 */
public enum CardItemTypeEnum {

    CAUSE_OF_DEATH(1, "死亡原因"),
    LOCATION_OF_CRIME(2, "犯罪地点"),
    CLUE(3, "线索蓝牌"),
    CRIME_CLUE(4, "线索"),
    CRIME_ITEM(5, "犯罪工具");

    private Integer key;
    private String name;

    CardItemTypeEnum(Integer key, String name){
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
