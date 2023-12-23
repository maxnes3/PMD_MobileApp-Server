package com.android.mobileappserver.User;

import com.android.mobileappserver.Story.StoryDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/get/{id}")
    public UserDTO get(@PathVariable("id") Long id){
        return new UserDTO(userService.getUserById(id));
    }

    @PostMapping("/signin")
    public UserDTO signIn(@RequestBody UserSignInDTO signInDTO){
        return new UserDTO(userService.signIn(signInDTO));
    }

    @PostMapping("/signup")
    public UserDTO signUp(@RequestBody UserDTO userDTO){
        UserModel user = userService.signUp(userDTO);
        return new UserDTO(user);
    }

    @PostMapping("/update")
    public UserDTO update(@RequestBody UserDTO userDTO){
        UserModel user = userService.update(userDTO);
        return new UserDTO(user);
    }

    @GetMapping("/getstories/{id}")
    public List<StoryDTO> getUserStories(@PathVariable("id") Long id){
        return userService.getUserStories(id).stream()
                .map(StoryDTO::new)
                .toList();
    }

    @GetMapping("/getAll")
    public List<UserDTO> getAll() {
        return userService.getAll().stream().map(
                UserDTO::new
        ).toList();
    }
}
