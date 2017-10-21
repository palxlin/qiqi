package com.csi.model.system;

import java.util.Date;

/**
 * Created by fanlin on 2017/10/17.
 */
public class Config {

    private Integer id;

    private String key;

    private String value;

    private Integer systemId;

    private Integer group;

    private Integer configDesc;

    private Integer recSt = 1;

    private Date createTime;

    public Integer getRecSt() {
        return recSt;
    }

    public void setRecSt(Integer recSt) {
        this.recSt = recSt;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getSystemId() {
        return systemId;
    }

    public void setSystemId(Integer systemId) {
        this.systemId = systemId;
    }

    public Integer getGroup() {
        return group;
    }

    public void setGroup(Integer group) {
        this.group = group;
    }

    public Integer getConfigDesc() {
        return configDesc;
    }

    public void setConfigDesc(Integer configDesc) {
        this.configDesc = configDesc;
    }
}
