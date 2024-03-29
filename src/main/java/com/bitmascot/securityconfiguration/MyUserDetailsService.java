package com.bitmascot.securityconfiguration;

import com.bitmascot.model.AppUser;
import com.bitmascot.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by motaleb14029 on 12/8/2019.
 */
@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    AppUserRepository appUserRepository;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        System.out.println("# Email : "+s);
        AppUser appUser = appUserRepository.findAppUserByEmail(s);
        System.out.println("# "+appUser);
        MyUserDetails myUserDetails = new MyUserDetails(appUser);
        return myUserDetails;
    }
}
