package com.springlearning.service;

import com.springlearning.model.UserAccount;
import com.springlearning.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.authority.AuthorityUtils;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

//@Service
//public class OrderUserDetailsService implements UserDetailsService {
public class OrderUserDetailsService {
//
//    @Autowired
//    UserAccountRepository userAccountRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Optional<UserAccount> byUsernameOptional = userAccountRepository.findByUsername(username);
//
//        if (!byUsernameOptional.isPresent()) {
//            throw new UsernameNotFoundException("Username " + username + " was not found.");
//        }
//
//        UserAccount fetchedUserAccount = byUsernameOptional.get();
//        return new User(fetchedUserAccount.getUsername(),
//                fetchedUserAccount.getPassword(),
//                fetchedUserAccount.isActive(),
//                fetchedUserAccount.isActive(),
//                fetchedUserAccount.isActive(),
//                fetchedUserAccount.isActive(),
//                AuthorityUtils.createAuthorityList("ADMIN", "USER")
//        );
//
//    }
}
