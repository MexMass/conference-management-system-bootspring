package com.lukas.ramonas.cms.Service;

import com.lukas.ramonas.cms.DAO.RoleRepository;
import com.lukas.ramonas.cms.DAO.UserDto;
import com.lukas.ramonas.cms.DAO.UserRepository;
import com.lukas.ramonas.cms.Exceptions.UserAlreadyExistException;
import com.lukas.ramonas.cms.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collections;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public User registerNewUserAccount(UserDto userDto)
            throws UserAlreadyExistException {

        if (emailExist(userDto.getEmail())) {
            throw new UserAlreadyExistException(
                    "There is an account with that email address: "
                            +  userDto.getEmail());
        }
        if (usernameExist(userDto.getUsername())) {
            throw new UserAlreadyExistException(
                    "There is an account with that username: "
                            +  userDto.getUsername());
        }
        User user = new User();
        user.setName(userDto.getName());
        user.setUsername(userDto.getUsername());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setEmail(userDto.getEmail());
        user.setRoles(Collections.singletonList(roleRepository.findByName(userDto.getRoles())));
        user.setConfirmed(Boolean.FALSE);
        return userRepository.save(user);
    }



    private boolean emailExist(String email) {
        return userRepository.findByEmail(email) != null;
    }

    private boolean usernameExist(String username) {
        return userRepository.findByUsername(username) != null;
    }
}