package com.dancingu.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Created by fanlin on 2017/10/23.
 */
public class Answer {

    private Integer a = 0;
    private Integer b = 0;
    private Integer c = 0;
    private Integer d = 0;
    private Integer e = 0;
    private Integer f = 0;

    public Integer getA() {
        return a;
    }

    public void setA(Integer a) {
        this.a = a;
    }

    public Integer getB() {
        return b;
    }

    public void setB(Integer b) {
        this.b = b;
    }

    public Integer getC() {
        return c;
    }

    public void setC(Integer c) {
        this.c = c;
    }

    public Integer getD() {
        return d;
    }

    public void setD(Integer d) {
        this.d = d;
    }

    public Integer getE() {
        return e;
    }

    public void setE(Integer e) {
        this.e = e;
    }

    public Integer getF() {
        return f;
    }

    public void setF(Integer f) {
        this.f = f;
    }

    public static Answer parse(String answerStr) {

        Answer answer = new Answer();

        if(answerStr.contains("A"))
            answer.setA(100);
        if(answerStr.contains("B"))
            answer.setB(100);
        if(answerStr.contains("C"))
            answer.setC(100);
        if(answerStr.contains("D"))
            answer.setD(100);
        if(answerStr.contains("E"))
            answer.setE(100);
        if(answerStr.contains("F"))
            answer.setF(100);

        return answer;
    }

    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SIMPLE_STYLE);
    }
}
