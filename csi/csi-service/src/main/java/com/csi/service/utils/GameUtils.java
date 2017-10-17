package com.csi.service.utils;

import com.csi.model.constants.enums.CardItemTypeEnum;
import com.csi.model.constants.enums.GameStatusEnums;
import com.csi.model.game.*;

import javax.smartcardio.Card;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by fanlin on 2017/10/13.
 */
public class GameUtils {

    /**
     * 生成新游戏
     */
    public static Game createGameBean(String createUser, String gameType, Integer numOfPlayers) {

        Game game = new Game();

        game.setCreateUser(createUser);
        game.setGameType(gameType);
        game.setNums(numOfPlayers);
        game.setStatus(GameStatusEnums.STARTING.getId());
        game.setGameNo(generateGameNo());

        /**随机生成杀手位置号*/
        Integer posKiller = generatePos(numOfPlayers);
        game.setPosOfCrimeUser(posKiller);
        /**随机生成帮凶位置号, 不同于杀手位置号*/
        Integer posKillerAss = generatePos(numOfPlayers, posKiller);
        game.setPosOfCrimeUserAss(posKillerAss);
        /**随机生成目击者位置号，不同于以上两个*/
        List<Integer> exceptions = new ArrayList<>();
        exceptions.add(posKiller);
        exceptions.add(posKillerAss);

        Integer posWitness = generatePos(numOfPlayers, exceptions);
        game.setPosOfWitness(posWitness);

        return game;
    }

    public static GameDetail createGameDetailBean(Game game) {
        GameDetail gameDetail = new GameDetail();

        gameDetail.setGameNo(game.getGameNo());

        /**生成死亡原因、案发地点以及四张蓝色线索牌
        gameDetail.setCauseOfDeath(CardStable.NUM_CAUSE_OF_DEATH);
        */

        gameDetail.setStatus(0);

        return gameDetail;
    }

    private static Integer generateGameNo() {

        return (new Random().nextInt(9000) + 1000);
    }

    public static Integer generatePos(Integer ceiling) {

        Integer randPos = new Random().nextInt(ceiling) + 1;

        return randPos;
    }

    private static Integer generatePos(Integer ceiling, Integer exceptions) {

        Random random = new Random();
        Integer randPos = random.nextInt(ceiling) + 1;

        int count = 100;
        while (exceptions == randPos) {
            randPos = random.nextInt(ceiling) + 1;
            if (count-- < 0) break;
        }

        return randPos;
    }

    private static Integer generatePos(Integer ceiling, List<Integer> exceptions) {

        Random random = new Random();
        Integer randPos = random.nextInt(ceiling) + 1;

        int count = 1000;
        while (exceptions.contains(randPos)) {
            randPos = random.nextInt(ceiling) + 1;
            if (count-- < 0) break;
        }

        return randPos;
    }

    public static PlayerVo createGamePlayerVo(String username, Integer gameNo) {

        PlayerVo playerVo = new PlayerVo();

        playerVo.setUserNo(username);
        playerVo.setGameNo(gameNo);
        playerVo.setGameRole(0);
        playerVo.setStatus(0);

        return playerVo;
    }

    public static List<Integer> parseVoList(List<ItemClueUsedVo> itemClueVoUsedList) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < itemClueVoUsedList.size(); i++) {
            ItemClueUsedVo itemClueUsedVo = itemClueVoUsedList.get(i);
            result.add(itemClueUsedVo.getCrime_item_1());
            result.add(itemClueUsedVo.getCrime_item_2());
            result.add(itemClueUsedVo.getCrime_item_3());
            result.add(itemClueUsedVo.getCrime_item_4());
            result.add(itemClueUsedVo.getCrime_clue_1());
            result.add(itemClueUsedVo.getCrime_clue_2());
            result.add(itemClueUsedVo.getCrime_clue_3());
            result.add(itemClueUsedVo.getCrime_clue_4());
        }

        return result;

    }

    public static List<ItemClueVo> find4(List<ItemClueVo> listAll, List<Integer> listExceptions) {
        List<ItemClueVo> result = new ArrayList<>();

        while (result.size() <= 4) {
            Integer pos = generatePos(listAll.size()) - 1;

            ItemClueVo itemClueVo = listAll.get(pos);
            Integer itemNo = itemClueVo.getItemNo();
            if (!listExceptions.contains(itemNo))
                result.add(itemClueVo);
        }

        return result;
    }

    public static boolean isElementBetweenMaxMin(Integer[] integers, Integer max, Integer min) {

        for (int i = 0; i < integers.length; i++) {
            if (integers[i] > max || integers[i] < min)
                return false;
        }
        return true;
    }

    public static boolean isElementBetweenMaxMin(String[] integers, Integer max, Integer min) {

        try {
            for (int i = 0; i < integers.length; i++) {
                if (Integer.parseInt(integers[i]) > max || Integer.parseInt(integers[i]) < min)
                    return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static boolean is123456(Integer num) {
        /*判断输入数字是否是6位数，而且每一位都是1-6且不相同*/
        if (num < 123456 || num > 654321)
            return false;

        String str = num.toString();
        int[] intArray = new int[str.length()];// 新建一个数组用来保存num每一位的数字
        for (int i = 0; i < str.length(); i++) {
            Character ch = str.charAt(i);
            intArray[i] = Integer.parseInt(ch.toString());
        }

        for (int i = 0; i < intArray.length; i++) {
            for (int j = i + 1; j < intArray.length; j++)
                if (intArray[i] == intArray[j])
                    return false;
        }

        return true;

    }

    public static PlayerVo setPlayerItem(PlayerVo playerVo, List<ItemClueVo> itemList, List<ItemClueVo> clueList) {

        playerVo.setCrimeItem1(itemList.get(0).getItemNo());
        playerVo.setCrimeItem2(itemList.get(1).getItemNo());
        playerVo.setCrimeItem3(itemList.get(2).getItemNo());
        playerVo.setCrimeItem4(itemList.get(3).getItemNo());

        playerVo.setCrimeClue1(clueList.get(0).getItemNo());
        playerVo.setCrimeClue2(clueList.get(1).getItemNo());
        playerVo.setCrimeClue3(clueList.get(2).getItemNo());
        playerVo.setCrimeClue4(clueList.get(3).getItemNo());

        playerVo.setCrimeItem1Name(itemList.get(0).getItemName());
        playerVo.setCrimeItem2Name(itemList.get(1).getItemName());
        playerVo.setCrimeItem3Name(itemList.get(2).getItemName());
        playerVo.setCrimeItem4Name(itemList.get(3).getItemName());

        playerVo.setCrimeClue1Name(clueList.get(0).getItemName());
        playerVo.setCrimeClue2Name(clueList.get(1).getItemName());
        playerVo.setCrimeClue3Name(clueList.get(2).getItemName());
        playerVo.setCrimeClue4Name(clueList.get(3).getItemName());

        playerVo.setCrimeItem1PicUrl(itemList.get(0).getItemPicUrl());
        playerVo.setCrimeItem2PicUrl(itemList.get(1).getItemPicUrl());
        playerVo.setCrimeItem3PicUrl(itemList.get(2).getItemPicUrl());
        playerVo.setCrimeItem4PicUrl(itemList.get(3).getItemPicUrl());

        playerVo.setCrimeClue1PicUrl(clueList.get(0).getItemPicUrl());
        playerVo.setCrimeClue2PicUrl(clueList.get(1).getItemPicUrl());
        playerVo.setCrimeClue3PicUrl(clueList.get(2).getItemPicUrl());
        playerVo.setCrimeClue4PicUrl(clueList.get(3).getItemPicUrl());
        return playerVo;
    }

    public static List<CrimeScene> random(List<CrimeScene> allCrimeScene, Integer randomNums) {

        Integer ceiling = allCrimeScene.size();
        List<CrimeScene> result = new ArrayList<>();
        List<Integer> exceptions = new ArrayList<>();

        for (int i = 0; i < randomNums; i++) {
            Integer num = generatePos(ceiling, exceptions) - 1;
            exceptions.add(num);
            result.add(allCrimeScene.get(num));
        }

        return result;
    }

    public static List<CrimeScene> filterCrimeScene(List<CrimeScene> allCrimeScene, Integer key) {

        List<CrimeScene> result = new ArrayList<>();

        for (CrimeScene crimeScene : allCrimeScene) {
            if (crimeScene.getItemType() == key)
                result.add(crimeScene);
        }

        return result;
    }

    public static String getNameByPos(Integer key, PlayerVo crimePlayer, Integer detectiveCrimeItemPos) {

        String text = "";
        if(key == CardItemTypeEnum.CRIME_ITEM.getKey()){
            switch (detectiveCrimeItemPos){
                case 1: text = crimePlayer.getCrimeItem1Name();break;
                case 2: text = crimePlayer.getCrimeItem2Name();break;
                case 3: text = crimePlayer.getCrimeItem3Name();break;
                case 4: text = crimePlayer.getCrimeItem4Name();break;
                default:break;
            }
        } else if (key == CardItemTypeEnum.CRIME_CLUE.getKey()){
            switch (detectiveCrimeItemPos){

                case 1: text = crimePlayer.getCrimeClue1Name();break;
                case 2: text = crimePlayer.getCrimeClue2Name();break;
                case 3: text = crimePlayer.getCrimeClue3Name();break;
                case 4: text = crimePlayer.getCrimeClue4Name();break;
                default:break;
            }
        }
        return text;
    }
}
