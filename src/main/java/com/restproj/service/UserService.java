package com.restproj.service;

import com.restproj.dao.NoteRepositoryRealImpl;
import com.restproj.dao.UserRepository;
import com.restproj.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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

    public User findById(Long id){
        Optional<User> opUser = userRepository.findById(id);
        if(opUser.isPresent()){
            return opUser.get();
        }
        throw new IllegalStateException();
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public void delete(User user){
        userRepository.delete(user);
    }
}
