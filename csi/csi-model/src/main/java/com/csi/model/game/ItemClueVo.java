package com.csi.model.game;

/**
 * Created by fanlin on 2017/10/13.
 */
public class ItemClueVo {

    private Integer playerPos;
    private Integer itemNo;
    private String itemName;
    private String itemPicUrl;


    public Integer getItemNo() {
        return itemNo;
    }

    public void setItemNo(Integer itemNo) {
        this.itemNo = itemNo;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemPicUrl() {
        return itemPicUrl;
    }

    public void setItemPicUrl(String itemPicUrl) {
        this.itemPicUrl = itemPicUrl;
    }

    public Integer getPlayerPos() {
        return playerPos;
    }

    public void setPlayerPos(Integer playerPos) {
        this.playerPos = playerPos;
    }
}
