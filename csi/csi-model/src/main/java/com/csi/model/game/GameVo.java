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
    private Integer nums;
    private Integer posOfCrimeUser;
    private Integer posOfCrimeAssUser;
    private Integer posOfWitnessUser;
    private Integer gameStatus;

    private Integer crimeItem;
    private Integer crimeClue;
    private String crimeItemName;
    private String crimeClueName;

    private Integer cardCauseOfDeath;
    private Integer cardLocationOfCrime;
    private String cardCauseOfDeathContent;
    private String cardLocationOfCrimeContent;

    private Integer cardClue1;
    private Integer cardClue2;
    private Integer cardClue3;
    private Integer cardClue4;
    private String cardClue1Content;
    private String cardClue2Content;
    private String cardClue3Content;
    private String cardClue4Content;
    private String cardClue1Title;
    private String cardClue2Title;
    private String cardClue3Title;
    private String cardClue4Title;

    private Integer cardClueToReplace1;
    private Integer cardClueToReplace2;
    private String cardClueToReplace1Content;
    private String cardClueToReplace2Content;
    private String cardClueToReplace1Title;
    private String cardClueToReplace2Title;

    private Integer witnessCauseOfDeath;
    private Integer witnessLocationOfCrime;
    private Integer witnessClue1;
    private Integer witnessClue2;
    private Integer witnessClue3;
    private Integer witnessClue4;

    private String witnessCauseOfDeathName;
    private String witnessLocationOfCrimeName;
    private String witnessClue1Name;
    private String witnessClue2Name;
    private String witnessClue3Name;
    private String witnessClue4Name;

    private Integer witnessWeight;

    private String remark;

    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SIMPLE_STYLE);
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

    public Integer getPosOfCrimeUser() {
        return posOfCrimeUser;
    }

    public void setPosOfCrimeUser(Integer posOfCrimeUser) {
        this.posOfCrimeUser = posOfCrimeUser;
    }

    public Integer getPosOfCrimeAssUser() {
        return posOfCrimeAssUser;
    }

    public void setPosOfCrimeAssUser(Integer posOfCrimeAssUser) {
        this.posOfCrimeAssUser = posOfCrimeAssUser;
    }

    public Integer getPosOfWitnessUser() {
        return posOfWitnessUser;
    }

    public void setPosOfWitnessUser(Integer posOfWitnessUser) {
        this.posOfWitnessUser = posOfWitnessUser;
    }

    public Integer getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(Integer gameStatus) {
        this.gameStatus = gameStatus;
    }

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

    public Integer getCardCauseOfDeath() {
        return cardCauseOfDeath;
    }

    public void setCardCauseOfDeath(Integer cardCauseOfDeath) {
        this.cardCauseOfDeath = cardCauseOfDeath;
    }

    public Integer getCardLocationOfCrime() {
        return cardLocationOfCrime;
    }

    public void setCardLocationOfCrime(Integer cardLocationOfCrime) {
        this.cardLocationOfCrime = cardLocationOfCrime;
    }

    public String getCardCauseOfDeathContent() {
        return cardCauseOfDeathContent;
    }

    public void setCardCauseOfDeathContent(String cardCauseOfDeathContent) {
        this.cardCauseOfDeathContent = cardCauseOfDeathContent;
    }

    public String getCardLocationOfCrimeContent() {
        return cardLocationOfCrimeContent;
    }

    public void setCardLocationOfCrimeContent(String cardLocationOfCrimeContent) {
        this.cardLocationOfCrimeContent = cardLocationOfCrimeContent;
    }

    public Integer getCardClue1() {
        return cardClue1;
    }

    public void setCardClue1(Integer cardClue1) {
        this.cardClue1 = cardClue1;
    }

    public Integer getCardClue2() {
        return cardClue2;
    }

    public void setCardClue2(Integer cardClue2) {
        this.cardClue2 = cardClue2;
    }

    public Integer getCardClue3() {
        return cardClue3;
    }

    public void setCardClue3(Integer cardClue3) {
        this.cardClue3 = cardClue3;
    }

    public Integer getCardClue4() {
        return cardClue4;
    }

    public void setCardClue4(Integer cardClue4) {
        this.cardClue4 = cardClue4;
    }

    public String getCardClue1Content() {
        return cardClue1Content;
    }

    public void setCardClue1Content(String cardClue1Content) {
        this.cardClue1Content = cardClue1Content;
    }

    public String getCardClue2Content() {
        return cardClue2Content;
    }

    public void setCardClue2Content(String cardClue2Content) {
        this.cardClue2Content = cardClue2Content;
    }

    public String getCardClue3Content() {
        return cardClue3Content;
    }

    public void setCardClue3Content(String cardClue3Content) {
        this.cardClue3Content = cardClue3Content;
    }

    public String getCardClue4Content() {
        return cardClue4Content;
    }

    public void setCardClue4Content(String cardClue4Content) {
        this.cardClue4Content = cardClue4Content;
    }

    public Integer getCardClueToReplace1() {
        return cardClueToReplace1;
    }

    public void setCardClueToReplace1(Integer cardClueToReplace1) {
        this.cardClueToReplace1 = cardClueToReplace1;
    }

    public Integer getCardClueToReplace2() {
        return cardClueToReplace2;
    }

    public void setCardClueToReplace2(Integer cardClueToReplace2) {
        this.cardClueToReplace2 = cardClueToReplace2;
    }

    public String getCardClueToReplace1Content() {
        return cardClueToReplace1Content;
    }

    public void setCardClueToReplace1Content(String cardClueToReplace1Content) {
        this.cardClueToReplace1Content = cardClueToReplace1Content;
    }

    public String getCardClueToReplace2Content() {
        return cardClueToReplace2Content;
    }

    public void setCardClueToReplace2Content(String cardClueToReplace2Content) {
        this.cardClueToReplace2Content = cardClueToReplace2Content;
    }

    public Integer getWitnessCauseOfDeath() {
        return witnessCauseOfDeath;
    }

    public void setWitnessCauseOfDeath(Integer witnessCauseOfDeath) {
        this.witnessCauseOfDeath = witnessCauseOfDeath;
    }

    public Integer getWitnessLocationOfCrime() {
        return witnessLocationOfCrime;
    }

    public void setWitnessLocationOfCrime(Integer witnessLocationOfCrime) {
        this.witnessLocationOfCrime = witnessLocationOfCrime;
    }

    public Integer getWitnessClue1() {
        return witnessClue1;
    }

    public void setWitnessClue1(Integer witnessClue1) {
        this.witnessClue1 = witnessClue1;
    }

    public Integer getWitnessClue2() {
        return witnessClue2;
    }

    public void setWitnessClue2(Integer witnessClue2) {
        this.witnessClue2 = witnessClue2;
    }

    public Integer getWitnessClue3() {
        return witnessClue3;
    }

    public void setWitnessClue3(Integer witnessClue3) {
        this.witnessClue3 = witnessClue3;
    }

    public Integer getWitnessClue4() {
        return witnessClue4;
    }

    public void setWitnessClue4(Integer witnessClue4) {
        this.witnessClue4 = witnessClue4;
    }

    public String getWitnessCauseOfDeathName() {
        return witnessCauseOfDeathName;
    }

    public void setWitnessCauseOfDeathName(String witnessCauseOfDeathName) {
        this.witnessCauseOfDeathName = witnessCauseOfDeathName;
    }

    public String getWitnessLocationOfCrimeName() {
        return witnessLocationOfCrimeName;
    }

    public void setWitnessLocationOfCrimeName(String witnessLocationOfCrimeName) {
        this.witnessLocationOfCrimeName = witnessLocationOfCrimeName;
    }

    public String getWitnessClue1Name() {
        return witnessClue1Name;
    }

    public void setWitnessClue1Name(String witnessClue1Name) {
        this.witnessClue1Name = witnessClue1Name;
    }

    public String getWitnessClue2Name() {
        return witnessClue2Name;
    }

    public void setWitnessClue2Name(String witnessClue2Name) {
        this.witnessClue2Name = witnessClue2Name;
    }

    public String getWitnessClue3Name() {
        return witnessClue3Name;
    }

    public void setWitnessClue3Name(String witnessClue3Name) {
        this.witnessClue3Name = witnessClue3Name;
    }

    public String getWitnessClue4Name() {
        return witnessClue4Name;
    }

    public void setWitnessClue4Name(String witnessClue4Name) {
        this.witnessClue4Name = witnessClue4Name;
    }

    public Integer getWitnessWeight() {
        return witnessWeight;
    }

    public void setWitnessWeight(Integer witnessWeight) {
        this.witnessWeight = witnessWeight;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCardClue1Title() {
        return cardClue1Title;
    }

    public void setCardClue1Title(String cardClue1Title) {
        this.cardClue1Title = cardClue1Title;
    }

    public String getCardClue2Title() {
        return cardClue2Title;
    }

    public void setCardClue2Title(String cardClue2Title) {
        this.cardClue2Title = cardClue2Title;
    }

    public String getCardClue3Title() {
        return cardClue3Title;
    }

    public void setCardClue3Title(String cardClue3Title) {
        this.cardClue3Title = cardClue3Title;
    }

    public String getCardClue4Title() {
        return cardClue4Title;
    }

    public void setCardClue4Title(String cardClue4Title) {
        this.cardClue4Title = cardClue4Title;
    }

    public String getCardClueToReplace1Title() {
        return cardClueToReplace1Title;
    }

    public void setCardClueToReplace1Title(String cardClueToReplace1Title) {
        this.cardClueToReplace1Title = cardClueToReplace1Title;
    }

    public String getCardClueToReplace2Title() {
        return cardClueToReplace2Title;
    }

    public void setCardClueToReplace2Title(String cardClueToReplace2Title) {
        this.cardClueToReplace2Title = cardClueToReplace2Title;
    }
}
