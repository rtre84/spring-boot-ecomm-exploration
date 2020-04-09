package com.springlearning;

import com.springlearning.model.UserAccount;
import com.springlearning.repository.UserAccountRepository;
import com.springlearning.service.OrderUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.authority.AuthorityUtils;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.factory.PasswordEncoderFactories;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Stream;

@EnableCircuitBreaker
@SpringBootApplication
public class OrderServiceApplication {

//    @Autowired
//    OrderUserDetailsService orderUserDetailsService;

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }


//    @Autowired
//    UserAccountRepository userAccountRepository;
//
//    @Bean
//    public CommandLineRunner commandLineRunner (UserAccountRepository userAccountRepository) {
//        String encodedPassword = new BCryptPasswordEncoder().encode("drwxrw23");
//        return args -> userAccountRepository.save(new UserAccount("admin", encodedPassword, true));
//    }
//
//
//    @Service
//    public class OOrderUserDetailsService implements UserDetailsService {
//
//        @Autowired
//        UserAccountRepository userAccountRepository;
//
//        @Override
//        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//            Optional<UserAccount> byUsernameOptional = userAccountRepository.findByUsername(username);
//
//            if (!byUsernameOptional.isPresent()) {
//                throw new UsernameNotFoundException("Username " + username + " was not found.");
//            }
//
//            UserAccount fetchedUserAccount = byUsernameOptional.get();
//            return new User(fetchedUserAccount.getUsername(),
//                    fetchedUserAccount.getPassword(),
//                    fetchedUserAccount.isActive(),
//                    fetchedUserAccount.isActive(),
//                    fetchedUserAccount.isActive(),
//                    fetchedUserAccount.isActive(),
//                    AuthorityUtils.createAuthorityList("ADMIN", "USER")
//            );
//
//        }
//    }

//    @Bean
//    public static NoOpPasswordEncoder noOpPasswordEncoder () {
//        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
//    }

}
