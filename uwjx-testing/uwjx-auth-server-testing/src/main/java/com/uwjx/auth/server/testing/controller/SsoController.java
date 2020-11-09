package com.uwjx.auth.server.testing.controller;

import com.alibaba.fastjson.JSON;
import com.uwjx.auth.server.testing.bean.OAuthTokenRequest;
import com.uwjx.components.commons.network.HttpRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class SsoController {


    @GetMapping(value = "codeHandler")
    public String ssoHandler(@RequestParam("code") String code) throws Exception {
        log.warn("获取到的code:{}" , code);
        HttpRequest httpRequest = new HttpRequest();
//        String url = "http://localhost:8080/oauth/token?grant_type=authorization_code&code="+code+"&redirect_uri=http://localhost:8090/codeHandler";
//        String url = "http://localhost:8080/oauth/token";
//        OAuthTokenRequest oAuthTokenRequest = new OAuthTokenRequest();
//        oAuthTokenRequest.setClient_id("client-01");
//        oAuthTokenRequest.setCode(code);
//        oAuthTokenRequest.setGrant_type("authorization_code");
//        oAuthTokenRequest.setRedirect_uri("http://localhost:8090/codeHandler");
//        String resp = httpRequest.post(url , "client-01" , "secret-01" , JSON.toJSONString(oAuthTokenRequest));

        String url = "http://localhost:8080/oauth/token?client_id=client-01&grant_type=authorization_code&code="+code+"&redirect_uri=http://localhost:8090/codeHandler";
        String resp = httpRequest.post(url , "client-01" , "secret-01");
        log.warn("code 处理结果:{}" , resp);
        return code;
    }
}
