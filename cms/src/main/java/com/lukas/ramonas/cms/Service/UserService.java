package com.lukas.ramonas.cms.Service;

import com.lukas.ramonas.cms.DAO.RoleRepository;
import com.lukas.ramonas.cms.DAO.UserDto;
import com.lukas.ramonas.cms.DAO.UserRepository;
import com.lukas.ramonas.cms.Exceptions.UserAlreadyExistException;
import com.lukas.ramonas.cms.Model.Role;
import com.lukas.ramonas.cms.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

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

    @Override
    public List<User> findAll() {

        var users = (List<User>) userRepository.findAll();

        return users;
    }

    @Override
    public List<User> findAllByRoles(String roles){
        return userRepository.findAllByRoles(roleRepository.findByName(roles));
    }

    @Override
    public User findByRoles(String roles) {
        return userRepository.findByRoles(roleRepository.findByName(roles));
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User updateConfirmed(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.get().getConfirmed() == true)
        {
            user.get().setConfirmed(false);
        } else {
            user.get().setConfirmed(true);
        }
        return userRepository.save(user.get());
    }

    @Override
    public Optional<User> findById(Long id) {

        return userRepository.findById(id);
    }



    private boolean emailExist(String email) {
        return userRepository.findByEmail(email) != null;
    }

    private boolean usernameExist(String username) {
        return userRepository.findByUsername(username) != null;
    }
}