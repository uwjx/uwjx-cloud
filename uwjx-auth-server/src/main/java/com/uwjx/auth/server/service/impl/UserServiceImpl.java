package com.uwjx.auth.server.service.impl;

import com.uwjx.auth.server.service.UserService;
import com.uwjx.auth.server.service.bean.UserBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    public UserBean findByUsername(String username) {
        UserBean userBean = new UserBean();
        userBean.setId(1001L);
        userBean.setUsername("wanghuan");
        userBean.setPassword("123456");
        return userBean;
    }
}
