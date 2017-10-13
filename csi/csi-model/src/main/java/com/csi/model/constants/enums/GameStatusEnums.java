package com.csi.model.constants.enums;

/**
 * Created by fanlin on 2017/10/13.
 */
public enum GameStatusEnums {

    STARTING(0, "游戏创建, 准备人满开始"),
    NIGHT_1_V4KILL(1, "人数已满，进入第一夜，等待凶手行凶"),
    NIGHT_1_V4SAW(2, "第一夜，凶手行凶结束，等待目击者选择目击情况"),
    DAY_1_V4JUDGE(3, "第一天，进入讨论以及断案过程"),
    NIGHT_2_V4REPL(4, "进入第二夜，帮凶选择是否替换线索牌"),
    NIGHT_2_V4SAW(5, "第二夜，根据帮凶是否替换线索牌，目击者进行相应操作"),
    DAY_2_V4JUDGE(6, "第二天，进入讨论以及断案过程"),
    NIGHT_3_V4PROC(7, "第三夜，目击者直接进行相应操作"),
    DAY_3_V4JUDGE(8, "第三天，进入讨论以及断案过程"),
    COMPLETED_SUCC(9, "游戏结束，凶手胜利"),
    COMPLETED_FAIL(10, "游戏结束，警察胜利"),
    UNCOMPLETELD(-1, "游戏结束，关键角色退出游戏");

    private Integer id;
    private String description;

    GameStatusEnums(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
