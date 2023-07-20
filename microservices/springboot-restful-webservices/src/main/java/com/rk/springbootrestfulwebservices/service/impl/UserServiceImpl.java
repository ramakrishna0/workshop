package com.rk.springbootrestfulwebservices.service.impl;

import com.rk.springbootrestfulwebservices.dto.UserDto;
import com.rk.springbootrestfulwebservices.entity.User;
import com.rk.springbootrestfulwebservices.mapper.UserMapper;
import com.rk.springbootrestfulwebservices.repository.UserRepository;
import com.rk.springbootrestfulwebservices.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
//    @Autowired //can be omitted for single instance variable class
    private UserRepository userRepository;
    @Override
    public UserDto createUser(UserDto userDto) {
        //convert userDto to user
        User user = UserMapper.mapToUser(userDto);
        User savedUser = userRepository.save(user);
        // convert user to userDto
        return UserMapper.mapToUserDto(savedUser);
    }

    @Override
    public UserDto getUserById(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
//        return optionalUser.get();
        return UserMapper.mapToUserDto(optionalUser.get());
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(UserMapper::mapToUserDto)
                .toList();
    }

    @Override
    public UserDto updateUser(UserDto user) {
        User existingUser = userRepository.findById(user.getId()).get();
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        return UserMapper.mapToUserDto(userRepository.save(existingUser));
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
