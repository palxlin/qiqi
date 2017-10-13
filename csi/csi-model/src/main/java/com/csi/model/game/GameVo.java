package com.csi.model.game;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Created by fanlin on 2017/10/12.
 */
public class GameVo {

    private Integer gameNo;
    private String gameType;
    private String createUser;
    private Integer playerNums;
    private String remark;

    public GameVo(String createUser, String gameType, Integer numOfPlayers) {
        this.createUser = createUser;
        this.gameType = gameType;
        this.playerNums = numOfPlayers;
    }

    public Integer getGameNo() {
        return gameNo;
    }

    public void setGameNo(Integer gameNo) {
        this.gameNo = gameNo;
    }

    public String getCreateUser() {
        return createUser;
    }

    public String getGameType() {
        return gameType;
    }

    public void setGameType(String gameType) {
        this.gameType = gameType;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Integer getPlayerNums() {
        return playerNums;
    }

    public void setPlayerNums(Integer playerNums) {
        this.playerNums = playerNums;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SIMPLE_STYLE);
    }
}
