package com.uwjx.auth.server.service;

import com.uwjx.auth.server.service.bean.UserBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class MyUserDetailsServiceImpl implements UserDetailsService {

    @Resource
    UserService userService;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserBean sysUser = userService.findByUsername(username);
        if (null == sysUser) {
            throw new UsernameNotFoundException(username);
        }
        List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
//        for (SysRole role : sysUser.getRoleList()) {
//            for (SysPermission permission : role.getPermissionList()) {
//                authorities.add(new SimpleGrantedAuthority(permission.getCode()));
//            }
//        }

        return new User(sysUser.getUsername(), sysUser.getPassword(), authorities);
    }
}
