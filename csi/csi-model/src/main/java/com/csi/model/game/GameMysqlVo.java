package com.csi.model.game;

import java.util.List;

/**
 * Created by fanlin on 2017/10/13.
 */
public class GameMysqlVo {


    private Integer id;
    private Integer game_no;
    private String game_type;
    private String create_user;
    private Integer nums;
    private Integer pos_of_crime_user;
    private Integer pos_of_crime_ass_user;
    private Integer pos_of_witness_user;
    private Integer status;
    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGame_no() {
        return game_no;
    }

    public void setGame_no(Integer game_no) {
        this.game_no = game_no;
    }

    public String getGame_type() {
        return game_type;
    }

    public void setGame_type(String game_type) {
        this.game_type = game_type;
    }

    public String getCreate_user() {
        return create_user;
    }

    public void setCreate_user(String create_user) {
        this.create_user = create_user;
    }

    public Integer getNums() {
        return nums;
    }

    public void setNums(Integer nums) {
        this.nums = nums;
    }

    public Integer getPos_of_crime_user() {
        return pos_of_crime_user;
    }

    public void setPos_of_crime_user(Integer pos_of_crime_user) {
        this.pos_of_crime_user = pos_of_crime_user;
    }

    public Integer getPos_of_crime_ass_user() {
        return pos_of_crime_ass_user;
    }

    public void setPos_of_crime_ass_user(Integer pos_of_crime_ass_user) {
        this.pos_of_crime_ass_user = pos_of_crime_ass_user;
    }

    public Integer getPos_of_witness_user() {
        return pos_of_witness_user;
    }

    public void setPos_of_witness_user(Integer pos_of_witness_user) {
        this.pos_of_witness_user = pos_of_witness_user;
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

}
