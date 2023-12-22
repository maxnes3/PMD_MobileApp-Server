package com.android.mobileappserver.User;

import com.android.mobileappserver.Mail.MailModel;
import com.android.mobileappserver.Story.StoryModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="_user")
public class UserModel {
    @Id
    @GeneratedValue
    private Long id;
    private String login;
    private String password;
    private String email;
    @Lob
    private byte[] photo;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    private List<StoryModel> stories;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    private List<MailModel> mails;

    public UserModel(String login, String email, String password, byte[] photo) {
        this.login = login;
        this.email = email;
        this.password = password;
        this.photo = photo;
    }
}
