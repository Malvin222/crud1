package com.crud1.crud1.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.crud1.crud1.domain.User;
import com.crud1.crud1.dto.UserDTO;
import com.crud1.crud1.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    @Override
    public Long register(UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        Long userno = userRepository.save(user).getUserno();

        return userno;
    }

    @Override
    public void remove(Long userno) {
        userRepository.deleteById(userno);
    }

    @Override
    public void modify(UserDTO userDTO) {
        Optional<User> result = userRepository.findById(userDTO.getUserno());
        User user = result.orElseThrow();
        user.change(userDTO.getUseremail(), userDTO.getUserphone());
        userRepository.save(user);
    }
    
}
