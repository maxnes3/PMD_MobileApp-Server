package com.android.mobileappserver.User;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.nio.charset.StandardCharsets;

@Data
@NoArgsConstructor
public class UserDTO {
    private Long id;
    private String login;
    private String password;
    private String email;
    private String photo;

    public UserDTO(UserModel user){
        this.id = user.getId();
        this.login = user.getLogin();
        this.password = user.getPassword();
        this.email = user.getEmail();
        this.photo = user.getPhoto() != null ? new String(user.getPhoto(), StandardCharsets.UTF_8) : null;
    }
}
