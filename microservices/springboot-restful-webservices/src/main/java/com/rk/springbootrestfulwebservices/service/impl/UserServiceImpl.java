package com.rk.springbootrestfulwebservices.service.impl;

import com.rk.springbootrestfulwebservices.dto.UserDto;
import com.rk.springbootrestfulwebservices.entity.User;
import com.rk.springbootrestfulwebservices.mapper.AutoUserMapper;
import com.rk.springbootrestfulwebservices.mapper.UserMapper;
import com.rk.springbootrestfulwebservices.repository.UserRepository;
import com.rk.springbootrestfulwebservices.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
//    @Autowired //can be omitted for classes with one constructor
    private UserRepository userRepository;
    private ModelMapper modelMapper;
    @Override
    public UserDto createUser(UserDto userDto) {
        //convert userDto to user
//        User user = UserMapper.mapToUser(userDto);
        User user = modelMapper.map(userDto, User.class);
        User savedUser = userRepository.save(user);
        // convert user to userDto
//        return UserMapper.mapToUserDto(savedUser);
//        return modelMapper.map(savedUser, UserDto.class);
        return AutoUserMapper.MAPPER.mapToUserDto(savedUser);
    }

    @Override
    public UserDto getUserById(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
//        return optionalUser.get();
//        return UserMapper.mapToUserDto(optionalUser.get());
//        return modelMapper.map(optionalUser.get(), UserDto.class);
        return AutoUserMapper.MAPPER.mapToUserDto(optionalUser.get());
    }

    @Override
    public List<UserDto> getAllUsers() {
        /*return userRepository.findAll().stream()
                .map(UserMapper::mapToUserDto)
                .toList();*/
        /*return userRepository.findAll().stream()
                .map(user -> modelMapper.map(user, UserDto.class))
                .toList();*/
        return userRepository.findAll().stream()
                .map(AutoUserMapper.MAPPER::mapToUserDto)
                .toList();
    }

    @Override
    public UserDto updateUser(UserDto user) {
        User existingUser = userRepository.findById(user.getId()).get();
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        // User updatedUser = userRepository.save(existingUser);
//        return UserMapper.mapToUserDto(userRepository.save(existingUser));
//        return modelMapper.map(userRepository.save(existingUser), UserDto.class);
        return AutoUserMapper.MAPPER.mapToUserDto(userRepository.save(existingUser));
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
