package com.csi.service;

import com.csi.dao.system.IConfigDao;
import com.csi.model.system.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Lin on 2017/11/5.
 */
@Service
@Transactional
public class ConfigService {

    @Autowired
    IConfigDao configDao;

    public List<Config> refresh(Integer systemId) {

        return configDao.refresh(systemId);
    }
}
