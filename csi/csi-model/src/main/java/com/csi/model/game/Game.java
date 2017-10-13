package com.csi.model.game;

/**
 * Created by fanlin on 2017/10/13.
 */
public class Game {

    private Integer id;
    private Integer gameNo;
    private String gameType;
    private String createUser;
    private Integer nums;
    private Integer posOfCrimeUser;
    private Integer posOfCrimeUserAss;
    private Integer posOfWitness;
    private Integer status;
    private String remark;

    public Integer getPosOfWitness() {
        return posOfWitness;
    }

    public void setPosOfWitness(Integer posOfWitness) {
        this.posOfWitness = posOfWitness;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGameNo() {
        return gameNo;
    }

    public void setGameNo(Integer gameNo) {
        this.gameNo = gameNo;
    }

    public String getGameType() {
        return gameType;
    }

    public void setGameType(String gameType) {
        this.gameType = gameType;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Integer getNums() {
        return nums;
    }

    public void setNums(Integer nums) {
        this.nums = nums;
    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getPosOfCrimeUser() {
        return posOfCrimeUser;
    }

    public void setPosOfCrimeUser(Integer posOfCrimeUser) {
        this.posOfCrimeUser = posOfCrimeUser;
    }

    public Integer getPosOfCrimeUserAss() {
        return posOfCrimeUserAss;
    }

    public void setPosOfCrimeUserAss(Integer posOfCrimeUserAss) {
        this.posOfCrimeUserAss = posOfCrimeUserAss;
    }
}
