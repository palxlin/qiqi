package com.csi.service.user.impl;

import com.csi.dao.user.IUserDao;
import com.csi.model.user.UserVo;
import com.csi.service.user.IUserService;
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
