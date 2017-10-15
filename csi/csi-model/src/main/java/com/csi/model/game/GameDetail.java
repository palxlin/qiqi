package com.csi.model.game;

import java.util.List;

/**
 * Created by fanlin on 2017/10/13.
 */
public class GameDetail {

    private Integer id;
    private Integer gameNo;
    private Integer status;
    private String remark;

    private Integer crimeItem;
    private Integer crimeClue;
    private String crimeItemName;
    private String crimeClueName;

    /**
     * 固定一张死亡原因
     */
    private Integer causeOfDeath;
    private String causeOfDeathContent;
    /**
     * 每局抽一张案发地点
     */
    private Integer locationOfCrime;
    private String locationOfCrimeContent;

    /**
     * 初始抽取四张线索蓝牌，游戏进程中可能被替换
     */
    private Integer clue1;
    private Integer clue2;
    private Integer clue3;
    private Integer clue4;
    private String clue1Content;
    private String clue2Content;
    private String clue3Content;
    private String clue4Content;
    private String clue1Title;
    private String clue2Title;
    private String clue3Title;
    private String clue4Title;

    private Integer clueToReplace1;
    private Integer clueToReplace2;
    private String clueToReplace1Content;
    private String clueToReplace2Content;
    private String clueToReplace1Title;
    private String clueToReplace2Title;

    private Integer witnessChosenCauseOfDeathPos;
    private Integer witnessChosenLocaionOfCrimePos;
    private Integer witnessChosenClue1Pos;
    private Integer witnessChosenClue2Pos;
    private Integer witnessChosenClue3Pos;
    private Integer witnessChosenClue4Pos;
    private String witnessChosenCauseOfDeathName;
    private String witnessChosenLocaionOfCrimeName;
    private String witnessChosenClue1Name;
    private String witnessChosenClue2Name;
    private String witnessChosenClue3Name;
    private String witnessChosenClue4Name;

    /**
     * 线索权重，6位数字对应6张牌上线索的权重，1-6从重到轻
     * 6张牌的顺序是死亡原因，案发地点，线索1，2，3，4
     */
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

    /**
     * 游戏进程中可能用到的替换蓝牌
     */
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

    /**
     * 凶手在第一夜选择的作案工具以及作案线索，作案线索在第二夜可能被帮凶替换
     */
    public Integer getCrimeItem() {
        return crimeItem;
    }

    public void setCrimeItem(Integer crimeItem) {
        this.crimeItem = crimeItem;
    }

    public Integer getCrimeClue() {
        return crimeClue;
    }

    public void setCrimeClue(Integer crimeClue) {
        this.crimeClue = crimeClue;
    }

    public String getCrimeItemName() {
        return crimeItemName;
    }

    public void setCrimeItemName(String crimeItemName) {
        this.crimeItemName = crimeItemName;
    }

    public String getCrimeClueName() {
        return crimeClueName;
    }

    public void setCrimeClueName(String crimeClueName) {
        this.crimeClueName = crimeClueName;
    }

    /**
     * 目击者选择的
     */
    public Integer getWitnessChosenCauseOfDeathPos() {
        return witnessChosenCauseOfDeathPos;
    }

    public void setWitnessChosenCauseOfDeathPos(Integer witnessChosenCauseOfDeathPos) {
        this.witnessChosenCauseOfDeathPos = witnessChosenCauseOfDeathPos;
    }

    public Integer getWitnessChosenLocaionOfCrimePos() {
        return witnessChosenLocaionOfCrimePos;
    }

    public void setWitnessChosenLocaionOfCrimePos(Integer witnessChosenLocaionOfCrimePos) {
        this.witnessChosenLocaionOfCrimePos = witnessChosenLocaionOfCrimePos;
    }

    public Integer getWitnessChosenClue1Pos() {
        return witnessChosenClue1Pos;
    }

    public void setWitnessChosenClue1Pos(Integer witnessChosenClue1Pos) {
        this.witnessChosenClue1Pos = witnessChosenClue1Pos;
    }

    public Integer getWitnessChosenClue2Pos() {
        return witnessChosenClue2Pos;
    }

    public void setWitnessChosenClue2Pos(Integer witnessChosenClue2Pos) {
        this.witnessChosenClue2Pos = witnessChosenClue2Pos;
    }

    public Integer getWitnessChosenClue3Pos() {
        return witnessChosenClue3Pos;
    }

    public void setWitnessChosenClue3Pos(Integer witnessChosenClue3Pos) {
        this.witnessChosenClue3Pos = witnessChosenClue3Pos;
    }

    public Integer getWitnessChosenClue4Pos() {
        return witnessChosenClue4Pos;
    }

    public void setWitnessChosenClue4Pos(Integer witnessChosenClue4Pos) {
        this.witnessChosenClue4Pos = witnessChosenClue4Pos;
    }

    public String getCauseOfDeathContent() {
        return causeOfDeathContent;
    }

    public void setCauseOfDeathContent(String causeOfDeathContent) {
        this.causeOfDeathContent = causeOfDeathContent;
    }

    public String getLocationOfCrimeContent() {
        return locationOfCrimeContent;
    }

    public void setLocationOfCrimeContent(String locationOfCrimeContent) {
        this.locationOfCrimeContent = locationOfCrimeContent;
    }

    public String getClue1Content() {
        return clue1Content;
    }

    public void setClue1Content(String clue1Content) {
        this.clue1Content = clue1Content;
    }

    public String getClue2Content() {
        return clue2Content;
    }

    public void setClue2Content(String clue2Content) {
        this.clue2Content = clue2Content;
    }

    public String getClue3Content() {
        return clue3Content;
    }

    public void setClue3Content(String clue3Content) {
        this.clue3Content = clue3Content;
    }

    public String getClue4Content() {
        return clue4Content;
    }

    public void setClue4Content(String clue4Content) {
        this.clue4Content = clue4Content;
    }

    public String getClue1Title() {
        return clue1Title;
    }

    public void setClue1Title(String clue1Title) {
        this.clue1Title = clue1Title;
    }

    public String getClue2Title() {
        return clue2Title;
    }

    public void setClue2Title(String clue2Title) {
        this.clue2Title = clue2Title;
    }

    public String getClue3Title() {
        return clue3Title;
    }

    public void setClue3Title(String clue3Title) {
        this.clue3Title = clue3Title;
    }

    public String getClue4Title() {
        return clue4Title;
    }

    public void setClue4Title(String clue4Title) {
        this.clue4Title = clue4Title;
    }

    public String getClueToReplace1Content() {
        return clueToReplace1Content;
    }

    public void setClueToReplace1Content(String clueToReplace1Content) {
        this.clueToReplace1Content = clueToReplace1Content;
    }

    public String getClueToReplace2Content() {
        return clueToReplace2Content;
    }

    public void setClueToReplace2Content(String clueToReplace2Content) {
        this.clueToReplace2Content = clueToReplace2Content;
    }

    public String getClueToReplace1Title() {
        return clueToReplace1Title;
    }

    public void setClueToReplace1Title(String clueToReplace1Title) {
        this.clueToReplace1Title = clueToReplace1Title;
    }

    public String getClueToReplace2Title() {
        return clueToReplace2Title;
    }

    public void setClueToReplace2Title(String clueToReplace2Title) {
        this.clueToReplace2Title = clueToReplace2Title;
    }

    public String getWitnessChosenCauseOfDeathName() {
        return witnessChosenCauseOfDeathName;
    }

    public void setWitnessChosenCauseOfDeathName(String witnessChosenCauseOfDeathName) {
        this.witnessChosenCauseOfDeathName = witnessChosenCauseOfDeathName;
    }

    public String getWitnessChosenLocaionOfCrimeName() {
        return witnessChosenLocaionOfCrimeName;
    }

    public void setWitnessChosenLocaionOfCrimeName(String witnessChosenLocaionOfCrimeName) {
        this.witnessChosenLocaionOfCrimeName = witnessChosenLocaionOfCrimeName;
    }

    public String getWitnessChosenClue1Name() {
        return witnessChosenClue1Name;
    }

    public void setWitnessChosenClue1Name(String witnessChosenClue1Name) {
        this.witnessChosenClue1Name = witnessChosenClue1Name;
    }

    public String getWitnessChosenClue2Name() {
        return witnessChosenClue2Name;
    }

    public void setWitnessChosenClue2Name(String witnessChosenClue2Name) {
        this.witnessChosenClue2Name = witnessChosenClue2Name;
    }

    public String getWitnessChosenClue3Name() {
        return witnessChosenClue3Name;
    }

    public void setWitnessChosenClue3Name(String witnessChosenClue3Name) {
        this.witnessChosenClue3Name = witnessChosenClue3Name;
    }

    public String getWitnessChosenClue4Name() {
        return witnessChosenClue4Name;
    }

    public void setWitnessChosenClue4Name(String witnessChosenClue4Name) {
        this.witnessChosenClue4Name = witnessChosenClue4Name;
    }

    public void setWitnessClue(List<CrimeScene> witnessClues) {
        CrimeScene crimeScene = witnessClues.get(0);

        this.setClue1(crimeScene.getItemNo());
        this.setClue1Content(crimeScene.getContent());
        this.setClue1Title(crimeScene.getRemark());

        crimeScene = witnessClues.get(1);
        this.setClue2(crimeScene.getItemNo());
        this.setClue2Content(crimeScene.getContent());
        this.setClue2Title(crimeScene.getRemark());

        crimeScene = witnessClues.get(2);
        this.setClue3(crimeScene.getItemNo());
        this.setClue3Content(crimeScene.getContent());
        this.setClue3Title(crimeScene.getRemark());

        crimeScene = witnessClues.get(3);
        this.setClue4(crimeScene.getItemNo());
        this.setClue4Content(crimeScene.getContent());
        this.setClue4Title(crimeScene.getRemark());
    }
}
