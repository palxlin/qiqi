package com.titan.csi.service.user.impl;

import com.titan.csi.dao.user.IUserDao;
import com.titan.csi.model.user.UserVo;
import com.titan.csi.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by fanlin on 2017/10/9.
 */
@Service("userService")
public class UserServiceImpl implements IUserService{
    @Autowired
    private IUserDao userDao;

    @Override
    public void addUser(UserVo userVo) throws Exception {
        userDao.addUser(userVo);
    }
}
