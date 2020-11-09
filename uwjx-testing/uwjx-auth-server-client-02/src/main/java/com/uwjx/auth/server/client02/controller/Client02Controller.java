package com.uwjx.auth.server.client02.controller;

import com.uwjx.components.commons.network.HttpRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@Slf4j
@RequestMapping(value = "client-02")
public class Client02Controller {

    @GetMapping(value = "list")
    public String list(@RequestParam("token")String token, HttpServletResponse response) throws Exception {
        HttpRequest httpRequest = new HttpRequest();
        String checkTokenUrl = "http://localhost:8080/oauth/check_token?token=" + token;
        String resp = httpRequest.post(checkTokenUrl ,"client-02" , "secret-02");
        log.warn("检查token的返回:{}" , resp);
        /**
         * {
         *     "active": true,
         *     "exp": 1604957927,
         *     "user_name": "wanghuan",
         *     "client_id": "client-01",
         *     "scope": [
         *         "scopes-01"
         *     ]
         * }
         */

        if(!resp.contains("user_name")){
            log.warn("TOKEN无效");
            String url ="http://localhost:8080/oauth/authorize?client_id=client-02&response_type=code&redirect_uri=http://localhost:8092/client-02/codeHandler";
            response.sendRedirect(url);
        }else {
            return resp;
        }

        return "ok";
    }

    @GetMapping(value = "codeHandler")
    public String ssoHandler(@RequestParam("code") String code) throws Exception {
        log.warn("获取到的code:{}" , code);
        HttpRequest httpRequest = new HttpRequest();
        String url = "http://localhost:8080/oauth/token?client_id=client-02&grant_type=authorization_code&code="+code+"&redirect_uri=http://localhost:8092/client-02/codeHandler";
        String resp = httpRequest.post(url , "client-02" , "secret-02");
        log.warn("code 处理结果:{}" , resp);
        return resp;
    }

}
