package com.csi.model.game;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Created by fanlin on 2017/10/12.
 */
public class GameVo {

    private Integer gameNo;
    private String createUser;
    private String type;
    private Integer playerNums;

    public GameVo(String createUser, String type, Integer numOfPlayers) {
        this.createUser = createUser;
        this.type = type;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SIMPLE_STYLE);
    }
}
