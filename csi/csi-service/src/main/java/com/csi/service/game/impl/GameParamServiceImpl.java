package com.csi.service.game.impl;

import com.csi.service.game.IGameParamService;
import com.csi.service.utils.GameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * Created by fanlin on 2017/10/14.
 */
@Service
public class GameParamServiceImpl implements IGameParamService {

    private static final Logger logger = LoggerFactory.getLogger(GameParamServiceImpl.class);

    @Override
    public boolean isCorrectParamCreateGame(String param) {
        /**"命令格式为：
         * c+空格+游戏人数
         * e.g. 输入[c 5]，表示创建5人局游戏"*/

        String[] params = param.split(" ");

        return params.length >= 2;

    }

    @Override
    public boolean isCorrectParamJoinGame(String param) {
        /**"命令格式为：
         * c+空格+房间号
         * e.g. 输入[j 5432]，表示加入5432房间"*/

        String[] params = param.split(" ");

        return params.length >= 2;
    }

    @Override
    public boolean isCorrectParamKill(String param) {
        /**"命令格式为：
         * c+空格+犯罪工具索引+犯罪线索索引
         * e.g. 输入[k 3 4]，表示使用3号工具及4号索引犯案*/

        try {
            String[] params = param.split(" ");

            if (params.length < 3)
                return false;

            return GameUtils.isElementBetweenMaxMin(
                    new Integer[]{Integer.parseInt(params[1]), Integer.parseInt(params[2])},
                    4, 1);

        } catch (Exception e) {

            return false;
        }

    }

    @Override
    public boolean isCorrectParamWitness(String param) {

        /**"命令格式为：
         * c+空格+死亡原因索引+案发地点索引+蓝牌索引*4+权重
         * e.g. 输入[w 4 5 3 3 2 6 324516]，表示使用3号工具及4号索引犯案*/

        try {
            String[] params = param.split(" ");

            if (params.length < 8)
                return false;

            String posArrays[] = Arrays.copyOfRange(params, 1, 7);

            if (!GameUtils.isElementBetweenMaxMin(posArrays, 4, 1))
                return false;

            Integer weight = Integer.parseInt(params[7]);
            boolean is123456 = GameUtils.is123456(weight);
            if (!is123456)
                return false;

            return true;

        } catch (Exception e) {

            return false;
        }
    }

    @Override
    public boolean isCorrectParamLookAllPlayer(String content) {
        return true;
    }

    @Override
    public boolean isCorrectParamLookCrime(String content) {
        return true;
    }

    @Override
    public boolean isCorrectParamLookWitness(String content) {
        return true;
    }

    @Override
    public boolean isCorrectParamDetectiveGame(String content) {


        /**"命令格式为：
         * g+空格+凶手位置+工具索引+线索索引
         * e.g. 输入[g 5 3 2]，表示5号是凶手，3号工具，2号线索"*/

        String[] params = content.split(" ");

        return params.length >= 4;
    }

}
