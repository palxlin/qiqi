package com.csi.model.game;

/**
 * Created by fanlin on 2017/10/13.
 */
public class PlayerVo {

    private String userNo;
    private Integer gameNo;
    private Integer gameRole;
    private Integer gameNums;
    private Integer gamePos;
    private Integer gameCrime; /*同伴的位置， 凶手 <-> 帮凶*/
    private Integer gameCrimeAss; /*同伴的位置， 凶手 <-> 帮凶*/
    private Integer gameWitness; /*同伴的位置， 凶手 <-> 帮凶*/
    private Integer status;
    private Integer crimeItem1;
    private Integer crimeItem2;
    private Integer crimeItem3;
    private Integer crimeItem4;
    private Integer crimeClue1;
    private Integer crimeClue2;
    private Integer crimeClue3;
    private Integer crimeClue4;
    private String crimeItem1Name;
    private String crimeItem2Name;
    private String crimeItem3Name;
    private String crimeItem4Name;
    private String crimeClue1Name;
    private String crimeClue2Name;
    private String crimeClue3Name;
    private String crimeClue4Name;
    private String crimeItem1PicUrl;
    private String crimeItem2PicUrl;
    private String crimeItem3PicUrl;
    private String crimeItem4PicUrl;
    private String crimeClue1PicUrl;
    private String crimeClue2PicUrl;
    private String crimeClue3PicUrl;
    private String crimeClue4PicUrl;
    private String remark;

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public Integer getGameNo() {
        return gameNo;
    }

    public void setGameNo(Integer gameNo) {
        this.gameNo = gameNo;
    }

    public Integer getGameRole() {
        return gameRole;
    }

    public void setGameRole(Integer gameRole) {
        this.gameRole = gameRole;
    }

    public Integer getGamePos() {
        return gamePos;
    }

    public void setGamePos(Integer gamePos) {
        this.gamePos = gamePos;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCrimeItem1() {
        return crimeItem1;
    }

    public void setCrimeItem1(Integer crimeItem1) {
        this.crimeItem1 = crimeItem1;
    }

    public Integer getCrimeItem2() {
        return crimeItem2;
    }

    public void setCrimeItem2(Integer crimeItem2) {
        this.crimeItem2 = crimeItem2;
    }

    public Integer getCrimeItem3() {
        return crimeItem3;
    }

    public void setCrimeItem3(Integer crimeItem3) {
        this.crimeItem3 = crimeItem3;
    }

    public Integer getCrimeItem4() {
        return crimeItem4;
    }

    public void setCrimeItem4(Integer crimeItem4) {
        this.crimeItem4 = crimeItem4;
    }

    public Integer getCrimeClue1() {
        return crimeClue1;
    }

    public void setCrimeClue1(Integer crimeClue1) {
        this.crimeClue1 = crimeClue1;
    }

    public Integer getCrimeClue2() {
        return crimeClue2;
    }

    public void setCrimeClue2(Integer crimeClue2) {
        this.crimeClue2 = crimeClue2;
    }

    public Integer getCrimeClue3() {
        return crimeClue3;
    }

    public void setCrimeClue3(Integer crimeClue3) {
        this.crimeClue3 = crimeClue3;
    }

    public Integer getCrimeClue4() {
        return crimeClue4;
    }

    public void setCrimeClue4(Integer crimeClue4) {
        this.crimeClue4 = crimeClue4;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }


    public String getCrimeItem1Name() {
        return crimeItem1Name;
    }

    public void setCrimeItem1Name(String crimeItem1Name) {
        this.crimeItem1Name = crimeItem1Name;
    }

    public String getCrimeItem2Name() {
        return crimeItem2Name;
    }

    public void setCrimeItem2Name(String crimeItem2Name) {
        this.crimeItem2Name = crimeItem2Name;
    }

    public String getCrimeItem3Name() {
        return crimeItem3Name;
    }

    public void setCrimeItem3Name(String crimeItem3Name) {
        this.crimeItem3Name = crimeItem3Name;
    }

    public String getCrimeItem4Name() {
        return crimeItem4Name;
    }

    public void setCrimeItem4Name(String crimeItem4Name) {
        this.crimeItem4Name = crimeItem4Name;
    }

    public String getCrimeClue1Name() {
        return crimeClue1Name;
    }

    public void setCrimeClue1Name(String crimeClue1Name) {
        this.crimeClue1Name = crimeClue1Name;
    }

    public String getCrimeClue2Name() {
        return crimeClue2Name;
    }

    public void setCrimeClue2Name(String crimeClue2Name) {
        this.crimeClue2Name = crimeClue2Name;
    }

    public String getCrimeClue3Name() {
        return crimeClue3Name;
    }

    public void setCrimeClue3Name(String crimeClue3Name) {
        this.crimeClue3Name = crimeClue3Name;
    }

    public String getCrimeClue4Name() {
        return crimeClue4Name;
    }

    public void setCrimeClue4Name(String crimeClue4Name) {
        this.crimeClue4Name = crimeClue4Name;
    }

    public String getCrimeItem1PicUrl() {
        return crimeItem1PicUrl;
    }

    public void setCrimeItem1PicUrl(String crimeItem1PicUrl) {
        this.crimeItem1PicUrl = crimeItem1PicUrl;
    }

    public String getCrimeItem2PicUrl() {
        return crimeItem2PicUrl;
    }

    public void setCrimeItem2PicUrl(String crimeItem2PicUrl) {
        this.crimeItem2PicUrl = crimeItem2PicUrl;
    }

    public String getCrimeItem3PicUrl() {
        return crimeItem3PicUrl;
    }

    public void setCrimeItem3PicUrl(String crimeItem3PicUrl) {
        this.crimeItem3PicUrl = crimeItem3PicUrl;
    }

    public String getCrimeItem4PicUrl() {
        return crimeItem4PicUrl;
    }

    public void setCrimeItem4PicUrl(String crimeItem4PicUrl) {
        this.crimeItem4PicUrl = crimeItem4PicUrl;
    }

    public String getCrimeClue1PicUrl() {
        return crimeClue1PicUrl;
    }

    public void setCrimeClue1PicUrl(String crimeClue1PicUrl) {
        this.crimeClue1PicUrl = crimeClue1PicUrl;
    }

    public String getCrimeClue2PicUrl() {
        return crimeClue2PicUrl;
    }

    public void setCrimeClue2PicUrl(String crimeClue2PicUrl) {
        this.crimeClue2PicUrl = crimeClue2PicUrl;
    }

    public String getCrimeClue3PicUrl() {
        return crimeClue3PicUrl;
    }

    public void setCrimeClue3PicUrl(String crimeClue3PicUrl) {
        this.crimeClue3PicUrl = crimeClue3PicUrl;
    }

    public String getCrimeClue4PicUrl() {
        return crimeClue4PicUrl;
    }

    public void setCrimeClue4PicUrl(String crimeClue4PicUrl) {
        this.crimeClue4PicUrl = crimeClue4PicUrl;
    }

    public Integer getGameNums() {
        return gameNums;
    }

    public void setGameNums(Integer gameNums) {
        this.gameNums = gameNums;
    }

    public Integer getGameCrime() {
        return gameCrime;
    }

    public void setGameCrime(Integer gameCrime) {
        this.gameCrime = gameCrime;
    }

    public Integer getGameCrimeAss() {
        return gameCrimeAss;
    }

    public void setGameCrimeAss(Integer gameCrimeAss) {
        this.gameCrimeAss = gameCrimeAss;
    }

    public Integer getGameWitness() {
        return gameWitness;
    }

    public void setGameWitness(Integer gameWitness) {
        this.gameWitness = gameWitness;
    }
}
