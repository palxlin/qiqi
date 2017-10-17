package com.csi.model.constants.enums;

/**
 * Created by fanlin on 2017/10/13.
 */
public enum GameStatusEnums {

    /**
     * id三位数字：
     * 第一位: 1表示夜晚，2表示白天, 9表示游戏结束
     * 第二位：表示当前是第几个白天或夜晚
     * 第三位：当时（夜晚或白天）的第几步
     */
    STARTING(0, "游戏创建成功，开始游戏"),
    NIGHT_1_CRIME(111, "人数已满，进入第一夜，等待凶手行凶"),
    NIGHT_1_WITNESS(112, "第一夜，凶手行凶结束，等待目击者选择目击情况"),
    DAY_1_V4JUDGE(211, "第一天，进入讨论以及断案过程"),
    NIGHT_2_CRIME_ASSIST(121, "进入第二夜，帮凶选择是否替换线索牌"),
    NIGHT_2_WITNESS(122, "第二夜，根据帮凶是否替换线索牌，目击者进行相应操作"),
    DAY_2_V4JUDGE(221, "第二天，进入讨论以及断案过程"),
    NIGHT_3_WITNESS(131, "第三夜，目击者直接进行相应操作"),
    DAY_3_V4JUDGE(231, "第三天，进入讨论以及断案过程"),
    COMPLETED_CRIME_SUCC(900, "游戏结束，凶手胜利"),
    COMPLETED_DETECT_SUCC(901, "游戏结束，警察胜利"),
    UNCOMPLETELD(902, "游戏结束，关键角色退出游戏");

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

    public static Integer[] availablePhase() {
        /**游戏中*/
        return new Integer[]{
                GameStatusEnums.STARTING.getId(),
                GameStatusEnums.NIGHT_1_CRIME.getId(),
                GameStatusEnums.NIGHT_1_CRIME.getId(),
                GameStatusEnums.DAY_1_V4JUDGE.getId(),
                GameStatusEnums.DAY_2_V4JUDGE.getId(),
                GameStatusEnums.DAY_3_V4JUDGE.getId(),
                GameStatusEnums.NIGHT_2_CRIME_ASSIST.getId(),
                GameStatusEnums.NIGHT_2_WITNESS.getId(),
                GameStatusEnums.NIGHT_3_WITNESS.getId()
        };
    }

    public static Integer[] dayPhase() {
        /*白天阶段，可断案*/
        return new Integer[]{
                GameStatusEnums.DAY_1_V4JUDGE.getId(),
                GameStatusEnums.DAY_2_V4JUDGE.getId(),
                GameStatusEnums.DAY_3_V4JUDGE.getId()
        };
    }

    public static Integer[] lookCrimePhase() {
        /*可查看凶犯工具和线索的阶段*/
        return new Integer[]{
                GameStatusEnums.NIGHT_1_WITNESS.getId(),
                GameStatusEnums.DAY_1_V4JUDGE.getId(),
                GameStatusEnums.NIGHT_2_CRIME_ASSIST.getId(),
                GameStatusEnums.NIGHT_2_WITNESS.getId(),
                GameStatusEnums.DAY_2_V4JUDGE.getId(),
                GameStatusEnums.NIGHT_3_WITNESS.getId(),
                GameStatusEnums.DAY_3_V4JUDGE.getId()
        };
    }

    public static Integer[] lookWitnessPhase() {
        /*可查看目击者口的阶段*/
        return new Integer[]{
                GameStatusEnums.DAY_1_V4JUDGE.getId(),
                GameStatusEnums.NIGHT_2_CRIME_ASSIST.getId(),
                GameStatusEnums.NIGHT_2_WITNESS.getId(),
                GameStatusEnums.DAY_2_V4JUDGE.getId(),
                GameStatusEnums.NIGHT_3_WITNESS.getId(),
                GameStatusEnums.DAY_3_V4JUDGE.getId()
        };
    }

    public static GameStatusEnums parse(Integer gameStatus) {

        for (GameStatusEnums gameStatusEnums : values()) {
            if (gameStatusEnums.getId().equals(gameStatus)) {
                return gameStatusEnums;
            }
        }
        return null;
    }

    public boolean isCompleted() {
        if (this.getId() == GameStatusEnums.COMPLETED_CRIME_SUCC.getId()
                || this.getId() == GameStatusEnums.COMPLETED_DETECT_SUCC.getId()
                || this.getId() == GameStatusEnums.UNCOMPLETELD.getId())
            return true;
        else
            return false;
    }
}
