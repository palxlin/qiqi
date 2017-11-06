package com.dancingu.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Created by fanlin on 2017/10/23.
 */
public class UploadRequest {

    private String identityNo;
    private String title;
    private String answer;

    public UploadRequest() {
    }

    public UploadRequest(String identityNo, String title, String answer) {
        this.identityNo = identityNo;
        this.title = title;
        this.answer = answer;
    }

    public String getIdentityNo() {
        return identityNo;
    }

    public void setIdentityNo(String identityNo) {
        this.identityNo = identityNo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SIMPLE_STYLE);
    }
}
