package com.dancingu.service.dancingu.impl;

import com.dancingu.dao.dancingu.IDancingUDao;
import com.dancingu.model.*;
import com.dancingu.service.dancingu.IDancingUService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by fanlin on 2017/10/23.
 */
@Service("dancingUService")
public class DancingUServiceImpl implements IDancingUService {

    private static final Logger logger = LoggerFactory.getLogger(DancingUServiceImpl.class);

    @Autowired
    IDancingUDao dancingUDao;

    @Override
    public Integer upload(UploadRequest uploadRequest) {

        logger.info("{} upload problem {}", uploadRequest.getIdentityNo(), uploadRequest);

        Answer answer = Answer.parse(uploadRequest.getAnswer());

        UploadVo uploadVo = new UploadVo(uploadRequest.getTitle(), answer);

        if (dancingUDao.existProblem(uploadVo) >= 1) {
            dancingUDao.updateProblem(uploadVo);
            logger.info("{} add problem {}", uploadRequest.getIdentityNo(), uploadRequest);
        } else {
            dancingUDao.addProblem(uploadVo);
            logger.info("{} update problem {}", uploadRequest.getIdentityNo(), uploadRequest);
        }

        return 0;
    }

    @Override
    public ResultVo query(QueryVo queryVo) {

        logger.info("{} query problem {}", queryVo.getIdentityNo(), queryVo);

        QueryResultVo queryResult = dancingUDao.queryProblem(queryVo);

        ResultVo result = new ResultVo(queryResult);

        result.setIndex(queryVo.getIndex());

        return result;
    }
}
