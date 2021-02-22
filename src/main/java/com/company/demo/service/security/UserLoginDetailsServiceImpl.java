package com.company.demo.service.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.demo.entities.security.UserLogin;
import com.company.demo.repository.security.UserLoginRepository;

@Service
@Transactional
public class UserLoginDetailsServiceImpl implements UserDetailsService {

	@Autowired
    private UserLoginRepository userLoginRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final UserLogin userLogin = userLoginRepository.findByUsername(username)
                	.orElseThrow(() -> 
                        new UsernameNotFoundException("User Not Found with -> username or email : " + username)
        );

        return UserLoginPrinciple.build(userLogin);
	}

}
