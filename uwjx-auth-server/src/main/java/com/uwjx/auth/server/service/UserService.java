package com.uwjx.auth.server.service;

import com.uwjx.auth.server.service.bean.UserBean;

public interface UserService {
    UserBean findByUsername(String username);
}
