package pl.wsb.fitnesstracker.user.internal;

import org.springframework.stereotype.Component;
import pl.wsb.fitnesstracker.user.api.User;
import pl.wsb.fitnesstracker.user.api.UserDto;
import pl.wsb.fitnesstracker.user.api.UserShortDto;
import pl.wsb.fitnesstracker.user.api.UserShortEmailDto;

@Component
class UserMapper {

    UserDto toUserDto(User user) {
        return new UserDto(user.getId(), user.getFirstName(), user.getLastName(), user.getBirthdate(), user.getEmail());
    }

    UserShortDto toUserShortDto(User user){
        return new UserShortDto(user.getId(), user.getFirstName(), user.getLastName());
    }

    UserShortEmailDto toUserShortEmailDto(User user){
        return new UserShortEmailDto(user.getId(), user.getEmail());
    }

    User toUser(UserDto userDto) {
        return new User(userDto.firstName(), userDto.lastName(), userDto.birthdate(), userDto.email());
    }


}
