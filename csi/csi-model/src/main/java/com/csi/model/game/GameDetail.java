package com.csi.model.game;

/**
 * Created by fanlin on 2017/10/13.
 */
public class GameDetail {

    private Integer id;
    private Integer gameNo;
    private Integer status;
    private String remark;

    /**凶手在第一夜选择的作案工具以及作案线索，作案线索在第二夜可能被帮凶替换*/
    private String crimeItem;
    private String crimeClue;

    /**固定一张死亡原因*/
    private Integer causeOfDeath;
    /**每局抽一张案发地点*/
    private Integer locationOfCrime;

    /**初始抽取四张线索蓝牌，游戏进程中可能被替换*/
    private Integer clue1;
    private Integer clue2;
    private Integer clue3;
    private Integer clue4;

    /**游戏进程中可能用到的替换蓝牌*/
    private Integer clueToReplace1;
    private Integer clueToReplace2;

    /**目击者选择的*/
    private Integer witnessChosenCauseOfDeath;
    private Integer witnessChosenLocaionOfCrime;
    private Integer witnessChosenClue1;
    private Integer witnessChosenClue2;
    private Integer witnessChosenClue3;
    private Integer witnessChosenClue4;

    /**线索权重，6位数字对应6张牌上线索的权重，1-6从重到轻
     * 6张牌的顺序是死亡原因，案发地点，线索1，2，3，4*/
    private Integer weight;

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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCrimeItem() {
        return crimeItem;
    }

    public void setCrimeItem(String crimeItem) {
        this.crimeItem = crimeItem;
    }

    public String getCrimeClue() {
        return crimeClue;
    }

    public void setCrimeClue(String crimeClue) {
        this.crimeClue = crimeClue;
    }

    public Integer getCauseOfDeath() {
        return causeOfDeath;
    }

    public void setCauseOfDeath(Integer causeOfDeath) {
        this.causeOfDeath = causeOfDeath;
    }

    public Integer getLocationOfCrime() {
        return locationOfCrime;
    }

    public void setLocationOfCrime(Integer locationOfCrime) {
        this.locationOfCrime = locationOfCrime;
    }

    public Integer getClue1() {
        return clue1;
    }

    public void setClue1(Integer clue1) {
        this.clue1 = clue1;
    }

    public Integer getClue2() {
        return clue2;
    }

    public void setClue2(Integer clue2) {
        this.clue2 = clue2;
    }

    public Integer getClue3() {
        return clue3;
    }

    public void setClue3(Integer clue3) {
        this.clue3 = clue3;
    }

    public Integer getClue4() {
        return clue4;
    }

    public void setClue4(Integer clue4) {
        this.clue4 = clue4;
    }

    public Integer getClueToReplace1() {
        return clueToReplace1;
    }

    public void setClueToReplace1(Integer clueToReplace1) {
        this.clueToReplace1 = clueToReplace1;
    }

    public Integer getClueToReplace2() {
        return clueToReplace2;
    }

    public void setClueToReplace2(Integer clueToReplace2) {
        this.clueToReplace2 = clueToReplace2;
    }

    public Integer getWitnessChosenCauseOfDeath() {
        return witnessChosenCauseOfDeath;
    }

    public void setWitnessChosenCauseOfDeath(Integer witnessChosenCauseOfDeath) {
        this.witnessChosenCauseOfDeath = witnessChosenCauseOfDeath;
    }

    public Integer getWitnessChosenLocaionOfCrime() {
        return witnessChosenLocaionOfCrime;
    }

    public void setWitnessChosenLocaionOfCrime(Integer witnessChosenLocaionOfCrime) {
        this.witnessChosenLocaionOfCrime = witnessChosenLocaionOfCrime;
    }

    public Integer getWitnessChosenClue1() {
        return witnessChosenClue1;
    }

    public void setWitnessChosenClue1(Integer witnessChosenClue1) {
        this.witnessChosenClue1 = witnessChosenClue1;
    }

    public Integer getWitnessChosenClue2() {
        return witnessChosenClue2;
    }

    public void setWitnessChosenClue2(Integer witnessChosenClue2) {
        this.witnessChosenClue2 = witnessChosenClue2;
    }

    public Integer getWitnessChosenClue3() {
        return witnessChosenClue3;
    }

    public void setWitnessChosenClue3(Integer witnessChosenClue3) {
        this.witnessChosenClue3 = witnessChosenClue3;
    }

    public Integer getWitnessChosenClue4() {
        return witnessChosenClue4;
    }

    public void setWitnessChosenClue4(Integer witnessChosenClue4) {
        this.witnessChosenClue4 = witnessChosenClue4;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
