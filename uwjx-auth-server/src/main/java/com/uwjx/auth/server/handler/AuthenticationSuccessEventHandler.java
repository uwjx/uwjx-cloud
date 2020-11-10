package com.uwjx.auth.server.handler;


import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

/**
 * 认证成功处理
 *
 * @author ruoyi
 */
@Component
@Slf4j
public class AuthenticationSuccessEventHandler implements ApplicationListener<AuthenticationSuccessEvent>
{

    @Override
    public void onApplicationEvent(AuthenticationSuccessEvent event)
    {
        Authentication authentication = (Authentication) event.getSource();
        log.warn("登录成功事件监听");
        log.warn("登录成功事件监听 -> {}" , JSON.toJSONString(authentication));
//        if (StringUtils.isNotEmpty(authentication.getAuthorities())
//                && authentication.getPrincipal() instanceof LoginUser)
//        {
//            LoginUser user = (LoginUser) authentication.getPrincipal();
//
//        }
    }
}
