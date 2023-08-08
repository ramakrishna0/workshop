package com.rk.springbootrestfulwebservices.mapper;

import com.rk.springbootrestfulwebservices.dto.UserDto;
import com.rk.springbootrestfulwebservices.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoUserMapper {
    AutoUserMapper MAPPER = Mappers.getMapper(AutoUserMapper.class);

    User mapToUser(UserDto userDto);

    UserDto mapToUserDto(User user);

}
