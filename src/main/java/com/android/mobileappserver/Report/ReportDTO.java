package com.android.mobileappserver.Report;

import com.android.mobileappserver.Story.StoryDTO;
import com.android.mobileappserver.User.UserDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ReportDTO {
    private Long dateFrom;
    private Long dateTo;
    private int postCount;
    private UserDTO mostPostAuthor;
    private int mostPostCount;
    private List<StoryDTO> listPostAuthor;

    public ReportDTO(Long dateFrom, Long dateTo, int postCount, UserDTO mostPostAuthor, int mostPostCount, List<StoryDTO> listPostAuthor){
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.postCount = postCount;
        this.mostPostAuthor = mostPostAuthor;
        this.mostPostCount = mostPostCount;
        this.listPostAuthor = listPostAuthor;
    }
}
