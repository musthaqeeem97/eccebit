package com.eccehomo.eccebit.service;


import com.eccehomo.eccebit.enums.VerificationType;
import com.eccehomo.eccebit.exception.UserException;
import com.eccehomo.eccebit.model.TwoFactorAuthentication;
import com.eccehomo.eccebit.model.User;
import com.eccehomo.eccebit.repository.UserRepository;
import com.eccehomo.eccebit.security.JWTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public User findUserProfileByJwt(String jwt) throws UserException {
        String email= JWTService.getEmailFromJwtToken(jwt);


        User user = userRepository.findByEmail(email);

        if(user==null) {
            throw new UserException("user not exist with email "+email);
        }
        return user;
    }

    @Override
    public User findUserByEmail(String username) throws UserException {

        User user=userRepository.findByEmail(username);

        if(user!=null) {

            return user;
        }

        throw new UserException("user not exist with username "+username);
    }

    @Override
    public User findUserById(Long userId) throws UserException {
        Optional<User> opt = userRepository.findById(userId);

        if(opt.isEmpty()) {
            throw new UserException("user not found with id "+userId);
        }
        return opt.get();
    }

    @Override
    public User verifyUser(User user) throws UserException {
        user.setVerified(true);
        return userRepository.save(user);
    }

    @Override
    public User enabledTwoFactorAuthentication(
            VerificationType verificationType, String sendTo, User user) throws UserException {
        TwoFactorAuthentication twoFactorAuthentication=new TwoFactorAuthentication();
        twoFactorAuthentication.setEnabled(true);
        twoFactorAuthentication.setType(verificationType);

        user.setTwoFactorAuth(twoFactorAuthentication);
        return userRepository.save(user);
    }

    @Override
    public User updatePassword(User user, String newPassword) {
        user.setPassword(passwordEncoder.encode(newPassword));
        return userRepository.save(user);
    }



}
