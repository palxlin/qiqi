package com.dancingu.model;

/**
 * Created by fanlin on 2017/10/23.
 */
public class UploadVo {

    private String title;
    private Answer answer;

    public UploadVo(String title, Answer answer) {
        this.title = title;
        this.answer = answer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }
}
