package com.android.mobileappserver.Story;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StoryDTO {
    private Long id;
    private String title;
    private String description;
    private byte[] cover;
    private Long postdate;
    private Long userId;

    public StoryDTO(StoryModel story){
        this.id = story.getId();
        this.title = story.getTitle();
        this.description = story.getDescription();
        this.cover = story.getCover();
        this.postdate = story.getPostdate();
        this.userId = story.getUser().getId();
    }
}
