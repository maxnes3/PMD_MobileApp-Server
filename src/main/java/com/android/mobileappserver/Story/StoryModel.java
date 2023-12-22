package com.android.mobileappserver.Story;

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
@Table(name="_story")
public class StoryModel {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String description;
    @Lob
    private byte[] cover;
    private Long postdate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private UserModel user;

    public StoryModel(String title, String description, byte[] cover, UserModel user){
        this.title = title;
        this.description = description;
        this.cover = cover;
        this.postdate = new Date().getTime();
        this.user = user;
    }
}
