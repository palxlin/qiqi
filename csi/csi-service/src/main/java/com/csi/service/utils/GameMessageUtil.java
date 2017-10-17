package com.csi.service.utils;

import com.csi.model.constants.enums.CardItemTypeEnum;
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
                "输入c [人数], 创建房间， 游戏建议4-10人\n" +
                "输入j [房间号], 进入房间\n" +
                "输入k [工具编号(1-4)] [线索编号(1-4)], 进行犯罪\n" +
                "输入w [死亡原因1-6] [案发地点1-6] [线索1] [线索2] [线索3] [线索4] [权重], 录口供\n" +
                "输入d [杀手编号] [杀手工具1-4] [杀手线索1-4], 进行断案\n" +
                "输入la, 查看全场人员拥有的工具和线索\n" +
                "输入lw, 查看目击者口供\n" +
                "输入lc, 直击现场(凶犯、帮凶，目击者可用)\n" +
                "输入lh, 查看侦探断案的历史情况\n" +
                "输入st, 查看游戏当前状态\n" +
                "输入exit退出当前游戏\n" +
                "输入h 查看游戏介绍\n";

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

        if (!gameRoleEnum.equals(GameRoleEnum.WITNESS)) {
            sb.append(String.format("作案工具[%s, %s, %s, %s]\n" +
                            "作案线索[%s, %s, %s, %s]\n",
                    playerVo.getCrimeItem1Name(), playerVo.getCrimeItem2Name(),
                    playerVo.getCrimeItem3Name(), playerVo.getCrimeItem4Name(),
                    playerVo.getCrimeClue1Name(), playerVo.getCrimeClue2Name(),
                    playerVo.getCrimeClue3Name(), playerVo.getCrimeClue4Name()));
        }

        if (gameRoleEnum.equals(GameRoleEnum.MURDER)) {

            sb.append("\n回复k [工具编号(1-4)] [线索编号(1-4)], 进行犯罪。");

            sb.append(String.format("\n\n你的帮凶同伴位置是[%d]号。\n回复lc可再查看你选择的作案工具及线索。", playerVo.getGameCrimeAss()));

        } else if (gameRoleEnum.equals(GameRoleEnum.MURDER_ASSIST)) {

            sb.append(String.format("\n你的凶手同伴位置是[%d]号。\n回复lc查看凶手的作案工具及线索。", playerVo.getGameCrime()));
        } else if (gameRoleEnum.equals(GameRoleEnum.WITNESS)) {

            sb.append(String.format("\n[%d]号为凶手，[%d]号为帮凶。\n回复lc查看凶手的作案工具及线索。", playerVo.getGameCrime(), playerVo.getGameCrimeAss()));
        }

        sb.append(String.format("\n\n回复lst查看游戏进程\n回复la查看所有玩家的作案工具线索\n回复lw查看[%d]号目击者的口供", playerVo.getGameWitness()));
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
            sb.append(String.format("[%d]号的工具是[%s][%s][%s][%s],\n线索是[%s][%s][%s][%s]\n",
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
                "死亡原因: [%s]\n" +
                        "案发地点: [%s]\n" +
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

        if (gameVo.getGameStatus() >= GameStatusEnums.NIGHT_1_WITNESS.getId()) {
            /**目击者选择结束*/
            sb.append(String.format("\n目击者口供录完(排序越前越重要)：\n" +
                            "死亡原因:[%s], 排序[%d]\n案发地点:[%s], 排序[%d]\n" +
                            "[%s]:[%s], 排序[%d]\n" +
                            "[%s]:[%s], 排序[%d]\n" +
                            "[%s]:[%s], 排序[%d]\n" +
                            "[%s]:[%s], 排序[%d]\n",
                    gameVo.getWitnessCauseOfDeathName(), gameVo.getWitnessCauseOfDeathWeight(),
                    gameVo.getWitnessLocationOfCrimeName(), gameVo.getWitnessLocationOfCrimeWeight(),
                    gameVo.getCardClue1Title(), gameVo.getWitnessClue1Name(), gameVo.getWitnessClue1Weight(),
                    gameVo.getCardClue2Title(), gameVo.getWitnessClue2Name(), gameVo.getWitnessClue2Weight(),
                    gameVo.getCardClue3Title(), gameVo.getWitnessClue3Name(), gameVo.getWitnessClue3Weight(),
                    gameVo.getCardClue4Title(), gameVo.getWitnessClue4Name(), gameVo.getWitnessClue4Weight()
            ));
        } else {
            sb.append("目击者口供尚未录完，请稍后再来");
        }

        return sb.toString();
    }

    public static String textExit() {

        return "你已退出当前游戏";
    }

    public static String textAllHistory(List<PlayerVo> playerVos) {

        StringBuilder sb = new StringBuilder();

        if (playerVos.size() > 0) {

            sb.append("当前断案历史为:\n");
            for (PlayerVo playerVo : playerVos) {

                PlayerVo crimePlayer = playerVo.getSuspectPlayer(playerVos);
                sb.append(String.format("[%d]号认为[%d]是凶手，使用了[%d]号工具[%s]，[%d]号线索[%s]\n",
                        playerVo.getGamePos(),
                        playerVo.getDetectiveCrimePos(),
                        playerVo.getDetectiveCrimeItemPos(),
                        GameUtils.getNameByPos(CardItemTypeEnum.CRIME_ITEM.getKey(), crimePlayer, playerVo.getDetectiveCrimeItemPos()),
                        playerVo.getDetectiveCrimeCluePos(),
                        GameUtils.getNameByPos(CardItemTypeEnum.CRIME_CLUE.getKey(), crimePlayer, playerVo.getDetectiveCrimeCluePos())));
            }
        } else {
            sb.append("当前暂无人断案");
        }

        return sb.toString();
    }

    public static String textGameStatus(GameVo gameVo) {
        StringBuilder sb = new StringBuilder();

        GameStatusEnums gameStatusEnums = GameStatusEnums.parse(gameVo.getGameStatus());
        sb.append(gameStatusEnums.getDescription());
        if(gameStatusEnums.isCompleted()) {
            sb.append(String.format("凶犯为[%d]玩家，帮凶为[%d]玩家，使用了[%s]工具，留下了[%s]线索",
                    gameVo.getPosOfCrimeUser(), gameVo.getPosOfCrimeAssUser(),
                    gameVo.getCrimeItemName(), gameVo.getCrimeClueName()));
        }

        return sb.toString();
    }
}
