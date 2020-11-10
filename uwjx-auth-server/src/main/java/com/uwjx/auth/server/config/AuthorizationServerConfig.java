package com.uwjx.auth.server.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

import javax.annotation.Resource;

/**
 * @author SalleyGardens
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Resource
    private AuthenticationManager authenticationManager;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("client-01")
                .secret("secret-01")
                .scopes("scopes-01")
                .authorizedGrantTypes("authorization_code" , "client_credentials", "password", "refresh_token")
                .redirectUris("http://localhost:8091/client-01/codeHandler")
                .autoApprove(true)
                .and()
                .withClient("client-02")
                .secret("secret-02")
                .scopes("scopes-02")
                .autoApprove(true)
                .authorizedGrantTypes("authorization_code" , "client_credentials", "password", "refresh_token")
                .redirectUris("http://localhost:8092/client-02/codeHandler");
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager);
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.checkTokenAccess("permitAll()");

    }
}
