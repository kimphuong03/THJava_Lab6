package com.example.Tuan3.services;

import com.example.Tuan3.entity.User;
import com.example.Tuan3.repository.IRoleRepository;
import com.example.Tuan3.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IRoleRepository repository;

    public void save(User user){
        userRepository.save(user);
        Long userId = userRepository.getUserIdUsername(user.getUsername());
        Long roleId = repository.getRoleByName("USER");
        if(roleId != 0 && userId != 0){
            userRepository.addRoleToUser(userId, roleId);
        }
    }
}