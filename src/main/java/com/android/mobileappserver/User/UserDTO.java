package com.android.mobileappserver.User;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDTO {
    private Long id;
    private String login;
    private String password;
    private String email;
    private byte[] photo;

    public UserDTO(UserModel user){
        this.id = user.getId();
        this.login = user.getLogin();
        this.password = user.getPassword();
        this.email = user.getEmail();
        this.photo = user.getPhoto();
    }
}
