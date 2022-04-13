package com.example.authenticationmicroservice.Service.Impl;

import com.example.authenticationmicroservice.Entity.Role;
import com.example.authenticationmicroservice.Entity.User;
import com.example.authenticationmicroservice.Repository.RoleRepository;
import com.example.authenticationmicroservice.Repository.UserRepository;
import com.example.authenticationmicroservice.Service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.logging.Logger;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService   {

    final private UserRepository userRepository ;
    final private RoleRepository roleRepository ;


    @Override
    public User saveUser(User user) {
         log.info("saving user  : {} " , user.getUsername());
        return userRepository.save(user);
    }




    @Override
    public User getUserByUserName(String username) {

        log.info("saving user  : {} " , username);
        return userRepository.findByUsername(username).orElse(null);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {

        log.info("adding role {}  to user {} " , roleName , username);

          this.userRepository.findByUsername(username)
                  .ifPresent(user ->{
                     final Role role = roleRepository.findByName(roleName).orElse(null);
                     user.getRoles().add(role) ;
                  });
    }

    @Override
    public List<User> getUsers() {
        log.info("find all users" );
        return userRepository.findAll();
    }
}
