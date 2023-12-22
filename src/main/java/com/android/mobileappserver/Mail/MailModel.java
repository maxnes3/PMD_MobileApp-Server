package com.android.mobileappserver.Mail;

import com.android.mobileappserver.User.UserModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="_mail")
public class MailModel {
    @Id
    @GeneratedValue
    private Long id;
    private String message;
    private Long postdate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private UserModel user;

    public MailModel(String message, UserModel user){
        this.message = message;
        this.postdate = new Date().getTime();
        this.user = user;
    }
}
