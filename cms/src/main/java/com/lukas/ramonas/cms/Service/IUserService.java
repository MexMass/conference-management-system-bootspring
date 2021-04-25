package com.lukas.ramonas.cms.Service;

import com.lukas.ramonas.cms.DAO.UserDto;
import com.lukas.ramonas.cms.Model.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    User registerNewUserAccount(UserDto userDto);

    List<User> findAll();

    Optional<User> findById(Long id);

    public void delete(Long id);
}