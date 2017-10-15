package com.csi.service.utils;

import com.csi.model.constants.enums.GameRoleEnum;
import com.csi.model.constants.enums.GameStatusEnums;
import com.csi.model.game.Game;
import com.csi.model.game.GameVo;
import com.csi.model.game.ItemClueVo;
import com.csi.model.game.PlayerVo;

import java.util.List;

/**
 * Created by fanlin on 2017/10/14.
 */
public class GameMessageUtil {

    public static String help() {

        String text = "欢迎来到CSI犯罪现场，你是侦探还是罪犯呢，你会目击这一切吗?\n" +
                "输入c[空格][人数]创建房间， 游戏建议4-10人" +
                "输入j[空格][房间号]进入房间" +
                "输入x退出当前房间" +
                "输入h 查看游戏介绍";

        return text;
    }

    public static String createSuccess(Integer gameNo, PlayerVo playerVo) {

        String textCreate = String.format("创建成功：游戏房间号为[%d]\n\n", gameNo);
        String textJoin = GameMessageUtil.joinSuccess(playerVo);

        return textCreate + textJoin;
    }

    public static String createSuccessWithJoinFail(Integer gameNo) {

        String textCreate = String.format("创建成功：游戏房间号为[%d]", gameNo);

        return textCreate + "\n\n自动加入游戏失败，请使用J命令加入游戏";
    }

    public static String joinSuccess(PlayerVo playerVo) {

        GameRoleEnum gameRoleEnum = GameRoleEnum.parse(playerVo.getGameRole());

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("你是[%d]号, 你的角色是[%s]。\n",
                playerVo.getGamePos(),
                gameRoleEnum.getName()));

        if(!gameRoleEnum.equals(GameRoleEnum.WITNESS)){
            sb.append(String.format("你拥有的作案工具[%s, %s, %s, %s]\n" +
                            "作案线索[%s, %s, %s, %s]。",
                    playerVo.getCrimeItem1Name(), playerVo.getCrimeItem2Name(),
                    playerVo.getCrimeItem3Name(), playerVo.getCrimeItem4Name(),
                    playerVo.getCrimeClue1Name(), playerVo.getCrimeClue2Name(),
                    playerVo.getCrimeClue3Name(), playerVo.getCrimeClue4Name()));
        }

        if (gameRoleEnum.equals(GameRoleEnum.MURDER)) {

            sb.append("\n回复k[空格][工具编号(1-4)][空格][线索编号(1-4)], 进行犯罪。");

            sb.append(String.format("\n你的凶手同伴位置是[%d]号。回复lc可再查看你选择的作案工具及线索。", playerVo.getGameCrimeAss()));

        } else if (gameRoleEnum.equals(GameRoleEnum.MURDER_ASSIST)) {

            sb.append(String.format("\n你的帮凶同伴位置是[%d]号。回复lc查看凶手的作案工具及线索。", playerVo.getGameCrime()));
        } else if (gameRoleEnum.equals(GameRoleEnum.WITNESS)) {

            sb.append(String.format("\n[%d]号为凶手，[%d]号为帮凶。回复lc查看凶手的作案工具及线索。", playerVo.getGameCrime(), playerVo.getGameCrimeAss()));
        }

        sb.append(String.format("\n回复la查看所有玩家的作案工具线索, 回复lw查看[%d]号目击者的口供。\n", playerVo.getGameWitness()));
        if (playerVo.getGamePos() < playerVo.getGameNums())
            sb.append("当前游戏人数未满，部分操作可能无法执行。");

        return sb.toString();
    }

    public static String killSuccess(Integer killItemPos, Integer killCluePos) {

        String text = String.format("杀人成功：使用工具[%d], 相关线索[%d]", killItemPos, killCluePos);

        return text;
    }

    public static String killFailed() {

        return "杀人失败，请重试";
    }

    public static String weinessSucess() {

        return "";
    }

    public static String joinFailed() {
        return "加入失败，请重试";
    }

    public static String textAllItems(List<PlayerVo> playerVos) {
        /**拼接所有人的工具和线索*/
        StringBuilder sb = new StringBuilder();

        sb.append("所有嫌疑人拥有的工具和线索如下\n");

        for (int i = 0; i < playerVos.size(); i++) {

            PlayerVo playerVo = playerVos.get(i);
            sb.append(String.format("[%d]号的工具是[%s][%s][%s][%s],线索是[%s][%s][%s][%s]",
                    playerVo.getGamePos(),
                    playerVo.getCrimeItem1Name(), playerVo.getCrimeItem2Name(),
                    playerVo.getCrimeItem3Name(), playerVo.getCrimeItem4Name(),
                    playerVo.getCrimeClue1Name(), playerVo.getCrimeClue2Name(),
                    playerVo.getCrimeClue3Name(), playerVo.getCrimeClue4Name()));
        }

        return sb.toString();
    }

    public static String textLookCrimeItem(GameVo gameVo) {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("[%d]号凶犯使用的犯罪工具是[%d]号工具[%s]，留下了[%d]号线索[%s]",
                gameVo.getPosOfCrimeUser(),
                gameVo.getCrimeItem(), gameVo.getCrimeItemName(),
                gameVo.getCrimeClue(), gameVo.getCrimeClueName()));

        return sb.toString();
    }

    public static String textLookWitness(GameVo gameVo) {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format(
                "死亡原因：[%s]\n案发地点[%s]\n" +
                        "[%s]: [%s]\n" +
                        "[%s]: [%s]\n" +
                        "[%s]: [%s]\n" +
                        "[%s]: [%s]\n",
                gameVo.getCardCauseOfDeathContent(),
                gameVo.getCardLocationOfCrimeContent(),
                gameVo.getCardClue1Title(), gameVo.getCardClue1Content(),
                gameVo.getCardClue2Title(), gameVo.getCardClue2Content(),
                gameVo.getCardClue3Title(), gameVo.getCardClue3Content(),
                gameVo.getCardClue4Title(), gameVo.getCardClue4Content()));

        if(gameVo.getGameStatus() >= GameStatusEnums.NIGHT_1_WITNESS.getId()){
            /**目击者选择结束*/
            sb.append(String.format("\n目击者口供录完：\n" +
                    "死亡原因[%d]案发地点[%d]\n" +
                    "[%s]:[%d]\n" +
                    "[%s]:[%d]\n" +
                    "[%s]:[%d]\n" +
                    "[%s]:[%d]\n",
                    gameVo.getWitnessCauseOfDeathName(), gameVo.getWitnessLocationOfCrimeName(),
                    gameVo.getCardClue1Title(), gameVo.getWitnessClue1Name(),
                    gameVo.getCardClue2Title(), gameVo.getWitnessClue2Name(),
                    gameVo.getCardClue3Title(), gameVo.getWitnessClue3Name(),
                    gameVo.getCardClue4Title(), gameVo.getWitnessClue4Name()
                    ));
        } else {
            sb.append("目击者口供尚未录完，请稍后再来");
        }

        return sb.toString();
    }
}
