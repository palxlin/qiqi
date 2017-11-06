package com.dancingu.dao.user;

import com.dancingu.model.user.UserVo;
import org.apache.ibatis.annotations.Param;

/**
 * Created by fanlin on 2017/10/9.
 */
public interface IUserDao {

    void addUser(@Param("user") UserVo user);
}
