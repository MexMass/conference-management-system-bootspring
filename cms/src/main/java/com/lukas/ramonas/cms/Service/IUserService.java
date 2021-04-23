package com.lukas.ramonas.cms.Service;

import com.lukas.ramonas.cms.DAO.UserDto;
import com.lukas.ramonas.cms.Exceptions.UserAlreadyExistException;
import com.lukas.ramonas.cms.Model.User;

public interface IUserService {

    User registerNewUserAccount(UserDto userDto);
}