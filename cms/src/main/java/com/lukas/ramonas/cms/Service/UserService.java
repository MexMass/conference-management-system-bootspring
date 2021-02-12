package com.lukas.ramonas.cms.Service;

import com.lukas.ramonas.cms.DAO.UserDto;
import com.lukas.ramonas.cms.DAO.UserRepository;
import com.lukas.ramonas.cms.Exceptions.UserAlreadyExistException;
import com.lukas.ramonas.cms.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    @Override
    public User registerNewUserAccount(UserDto userDto)
            throws UserAlreadyExistException {

        if (emailExist(userDto.getEmail())) {
            throw new UserAlreadyExistException(
                    "There is an account with that email address: "
                            +  userDto.getEmail());
        }
        User user = new User();
        user.setName(userDto.getName());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());
//        user.setRoles(userDto.getRoles());
        user.setConfirmed(Boolean.FALSE);
        return userRepository.save(user);
        // the rest of the registration operation
    }



    private boolean emailExist(String email) {
        return userRepository.findByEmail(email) != null;
    }
}