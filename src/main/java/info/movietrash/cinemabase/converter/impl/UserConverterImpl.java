package info.movietrash.cinemabase.converter.impl;

import info.movietrash.cinemabase.converter.UserConverter;
import info.movietrash.cinemabase.dto.UserDto;
import info.movietrash.cinemabase.model.User;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Component;

@Component
public class UserConverterImpl implements UserConverter {

    @Override
    public User toModel(UserDto userDto) {
        if (ObjectUtils.anyNull(userDto, userDto.getUsername(), userDto.getPassword())) {
            throw new IllegalArgumentException("Some of required fields is null: " + userDto);
        }
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        return user;
    }

    @Override
    public UserDto toDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());
        return userDto;
    }
}
