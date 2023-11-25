package com.crud1.crud1.service;

import com.crud1.crud1.dto.UserDTO;

public interface UserService {

    Long register(UserDTO userDTO);

    void remove(Long userno);

    void modify(UserDTO userDTO);
    
}