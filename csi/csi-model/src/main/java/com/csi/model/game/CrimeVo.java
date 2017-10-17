package com.csi.model.game;

/**
 * Created by fanlin on 2017/10/13.
 */
public class CrimeVo {

    private Integer crimePos;
    private Integer crimeItemPos;
    private Integer crimeCluePos;

    public CrimeVo() {}

    public CrimeVo(Integer killerPos, Integer itemPos, Integer cluePos) {
        this.crimePos = killerPos;
        this.crimeItemPos = itemPos;
        this.crimeCluePos = cluePos;
    }

    public Integer getCrimePos() {
        return crimePos;
    }

    public void setCrimePos(Integer crimePos) {
        this.crimePos = crimePos;
    }

    public Integer getCrimeItemPos() {
        return crimeItemPos;
    }

    public void setCrimeItemPos(Integer crimeItemPos) {
        this.crimeItemPos = crimeItemPos;
    }

    public Integer getCrimeCluePos() {
        return crimeCluePos;
    }

    public void setCrimeCluePos(Integer crimeCluePos) {
        this.crimeCluePos = crimeCluePos;
    }
}
