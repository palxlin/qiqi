package com.csi.dao.game;

import com.csi.model.game.GameVo;
import org.apache.ibatis.annotations.Param;

/**
 * Created by fanlin on 2017/10/12.
 */
public interface IGameDao {

    void createGame(@Param("game") GameVo game);
}
