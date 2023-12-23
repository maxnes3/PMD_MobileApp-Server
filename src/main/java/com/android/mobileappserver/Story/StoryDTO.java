package com.android.mobileappserver.Story;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.nio.charset.StandardCharsets;

@Data
@NoArgsConstructor
public class StoryDTO {
    private Long id;
    private String title;
    private String description;
    private String cover;
    private Long postdate;
    private Long userId;

    public StoryDTO(StoryModel story){
        this.id = story.getId();
        this.title = story.getTitle();
        this.description = story.getDescription();
        this.postdate = story.getPostdate();
        this.userId = story.getUser().getId();
        this.cover = new String(story.getCover(), StandardCharsets.UTF_8);
    }
}
