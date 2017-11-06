package com.dancingu.service.dancingu;

import com.dancingu.model.QueryVo;
import com.dancingu.model.ResultVo;
import com.dancingu.model.UploadRequest;

/**
 * Created by fanlin on 2017/10/23.
 */
public interface IDancingUService {

    Integer upload(UploadRequest uploadVo);
    ResultVo query(QueryVo queryVo);
}
