package com.android.mobileappserver.Report;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ReportDTO {
    private Long dateFrom;
    private Long dateTo;
    private int postCount;
    private String mostPostAuthor;
    private int mostPostCount;

    public ReportDTO(Long dateFrom, Long dateTo, int postCount, String mostPostAuthor, int mostPostCount){
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.postCount = postCount;
        this.mostPostAuthor = mostPostAuthor;
        this.mostPostCount = mostPostCount;
    }
}
