package com.uwjx.auth.server.controller;

import com.uwjx.components.commons.util.ResponseUtil;
import com.uwjx.components.commons.vo.DataVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping(value = "account")
public class AccountController {

    @PostMapping(value = "logout")
    public DataVO<Object> logout(){
        log.warn("执行退出登录");
        return ResponseUtil.success("");
    }
}
