package com.csi.dao.system;

import com.csi.model.system.Config;

import java.util.List;

/**
 * Created by Lin on 2017/11/5.
 */
public interface IConfigDao {
    List<Config> refresh(Integer systemId);
}
