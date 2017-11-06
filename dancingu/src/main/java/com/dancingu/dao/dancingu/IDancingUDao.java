package com.dancingu.dao.dancingu;

import com.dancingu.model.QueryResultVo;
import com.dancingu.model.QueryVo;
import com.dancingu.model.UploadVo;
import org.apache.ibatis.annotations.Param;

/**
 * Created by fanlin on 2017/10/23.
 */
public interface IDancingUDao {

    Integer existProblem(@Param("problem") UploadVo problem);
    void addProblem(@Param("problem") UploadVo problem);
    void updateProblem(@Param("problem") UploadVo problem);
    QueryResultVo queryProblem(@Param("problem") QueryVo problem);
}
