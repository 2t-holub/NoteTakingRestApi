package com.restproj.service;

import com.restproj.dao.NoteRepositoryRealImpl;
import com.restproj.dao.UserRepository;
import com.restproj.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findByLogin(String login){
        Optional<User> opUser = userRepository.findByLogin(login);
        if(opUser.isPresent()){
            return opUser.get();
        }
        throw new IllegalStateException();
    }

}
