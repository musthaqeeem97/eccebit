package com.eccehomo.eccebit.service;

import com.eccehomo.eccebit.enums.VerificationType;
import com.eccehomo.eccebit.exception.UserException;
import com.eccehomo.eccebit.model.User;

public interface UserService {

    public User findUserProfileByJwt(String jwt) throws UserException;

    public User findUserByEmail(String email) throws UserException;

    public User findUserById(Long userId) throws UserException;

    public User verifyUser(User user) throws UserException;

    public User enabledTwoFactorAuthentication(VerificationType verificationType,
                                               String sendTo, User user) throws UserException;

    User updatePassword(User user, String newPassword);


}

