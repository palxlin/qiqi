package com.csi.service.utils;

import com.csi.model.constants.CardStable;
import com.csi.model.constants.enums.GameStatusEnums;
import com.csi.model.game.Game;
import com.csi.model.game.GameDetail;
import com.csi.model.game.ItemClueUsedVo;
import com.csi.model.game.PlayerVo;

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

        /**生成死亡原因、案发地点以及四张蓝色线索牌*/
        gameDetail.setCauseOfDeath(CardStable.NUM_CAUSE_OF_DEATH);

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

    public static List<Integer> random4(List<Integer> witnesClues) {
        Integer ceiling = witnesClues.size();
        List<Integer> result = new ArrayList<Integer>();
        List<Integer> exceptions = new ArrayList<Integer>();

        Integer num1 = generatePos(ceiling);
        exceptions.add(num1);

        Integer num2 = generatePos(ceiling, exceptions);
        exceptions.add(num2);

        Integer num3 = generatePos(ceiling, exceptions);
        exceptions.add(num3);

        Integer num4 = generatePos(ceiling, exceptions);
        exceptions.add(num4);

        result.add(num1);
        result.add(num2);
        result.add(num3);
        result.add(num4);

        return result;
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

    public static List<Integer> find4(List<Integer> listAll, List<Integer> listExceptions) {
        List<Integer> result = new ArrayList<>();

        while (result.size() <=4 ) {
            Integer pos = generatePos(listAll.size());
            Integer itemNo = listAll.get(pos);
            if(!listExceptions.contains(itemNo))
                result.add(itemNo);
        }

        return result;
    }
}
