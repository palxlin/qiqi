package com.csi.model.constants.enums;

/**
 * Created by fanlin on 2017/10/14.
 */
public enum GameRoleEnum {

    DETECTIVE(0, "侦探"),
    MURDER(1, "凶手"),
    MURDER_ASSIST(2, "帮凶"),
    WITNESS(3, "目击者");

    private Integer key;
    private String name;

    GameRoleEnum(Integer key, String name){
        this.key = key;
        this.name = name;
    }


    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static GameRoleEnum parse(Integer gameRoleKey) {

        for (GameRoleEnum gameRoles: values()) {
            if (gameRoles.getKey().equals(gameRoleKey)) {
                return gameRoles;
            }
        }
        return null;
    }
}
