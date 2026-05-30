package pl.wsb.fitnesstracker.user.internal;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import pl.wsb.fitnesstracker.user.api.*;

import java.util.List;

/**
 * UserController is responsible for handling HTTP requests related to user operations.
 * It provides endpoints for retrieving and creating users.
 */
@Slf4j
@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
class UserController {

    private final UserService userService;

    private final UserProvider userProvider;

    private final UserMapper userMapper;

    @PostMapping
    @ResponseStatus(org.springframework.http.HttpStatus.CREATED)
    public UserDto addUser(@RequestBody UserDto userDto) throws InterruptedException {
        User user = this.userService.createUser(this.userMapper.toUser(userDto));
        return userMapper.toUserDto(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) throws InterruptedException {
        log.info("REST request to delete user with ID={}", id);
        this.userService.deleteUser(id);
    }

    @GetMapping
    public List<UserDto> getUsers() throws InterruptedException {

       return this.userProvider.findAllUsers().stream()
                .map(this.userMapper::toUserDto)
                .toList();
    }

    @GetMapping("/simple")
    public List<UserShortDto> getUsersShort() throws InterruptedException {

        return this.userProvider.findAllUsers().stream()
                .map(this.userMapper::toUserShortDto)
                .toList();
    }

    @GetMapping("/{id}")
    public UserDto getUser(@PathVariable Long id) throws InterruptedException {
        return this.userProvider.getUser(id)
                .map(this.userMapper::toUserDto)
                .orElseThrow();
    }

    @GetMapping("/email/{email}")
    public List<UserShortEmailDto> findUsersByEmail(@PathVariable String email) throws InterruptedException {
        return this.userProvider.getUsersByEmail(email).stream()
                .map(this.userMapper::toUserShortEmailDto)
                .toList();
//        return this.userProvider.getUserByEmail(email)
//                .map(this.userMapper::toUserShortEmailDto)
//                .orElseThrow(() -> new IllegalArgumentException("User with email " + email + " not found!"));
    }
}