package com.dancingu.model;

/**
 * Created by fanlin on 2017/10/23.
 */
public class ResultVo {

    private Boolean result;
    private String index;
    private Integer[] data;

    public ResultVo(){}
    public ResultVo(QueryResultVo queryResult) {

        this.result = true;
        this.data = new Integer[6];
        data[0] = queryResult.getAnswer1();
        data[1] = queryResult.getAnswer2();
        data[2] = queryResult.getAnswer3();
        data[3] = queryResult.getAnswer4();
        data[4] = queryResult.getAnswer5();
        data[5] = queryResult.getAnswer6();
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public Integer[] getData() {
        return data;
    }

    public void setData(Integer[] data) {
        this.data = data;
    }

}
