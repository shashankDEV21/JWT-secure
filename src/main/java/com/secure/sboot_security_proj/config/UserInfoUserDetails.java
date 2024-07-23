package com.secure.sboot_security_proj.config;

import com.secure.sboot_security_proj.entity.UserInfo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UserInfoUserDetails implements UserDetails {
    private String name;
    private String password;
    private List<GrantedAuthority> auth;
    public UserInfoUserDetails(UserInfo uinfo){
        name=uinfo.getName();
        password=uinfo.getPassword();
        auth= Arrays.stream(uinfo.getRoles().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return auth;
    }
    @Override
    public String getPassword() {
        return password;
    }
    @Override
    public String getUsername() {
        return name;
    }
}
