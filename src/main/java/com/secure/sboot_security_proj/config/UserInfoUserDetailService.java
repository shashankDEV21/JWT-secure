package com.secure.sboot_security_proj.config;

import com.secure.sboot_security_proj.entity.UserInfo;
import com.secure.sboot_security_proj.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public class UserInfoUserDetailService implements UserDetailsService {
    @Autowired
    private UserInfoRepository repo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserInfo>uinfo=repo.findByName(username);
return uinfo.map(UserInfoUserDetails::new)
        .orElseThrow(()->new UsernameNotFoundException("User name not found"));

    }
}
