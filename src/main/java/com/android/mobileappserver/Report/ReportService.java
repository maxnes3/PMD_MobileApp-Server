package com.android.mobileappserver.Report;

import com.android.mobileappserver.Story.StoryModel;
import com.android.mobileappserver.Story.StoryService;
import com.android.mobileappserver.User.UserService;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReportService {
    private final UserService userService;
    private final StoryService storyService;

    public ReportService(UserService userService, StoryService storyService){
        this.userService = userService;
        this.storyService = storyService;
    }

    @Transactional
    public ReportDTO createReport(ReportCreateDTO reportCreateDTO){
        List<StoryModel> stories = storyService.getStoriesByDate(reportCreateDTO.getDateFrom(), reportCreateDTO.getDateTo());
        int postCount = stories.size();
        Map<String, Integer> authorWithCount = new HashMap<>();
        for (var story: stories) {
            String authorName = story.getUser().getLogin();
            if (authorWithCount.containsKey(authorName)) {
                // Если автор уже есть, увеличиваем количество историй
                authorWithCount.put(authorName, authorWithCount.get(authorName) + 1);
            } else {
                // Если автора еще нет в мапе, добавляем его с количеством 1
                authorWithCount.put(authorName, 1);
            }
        }
        Map.Entry<String, Integer> maxEntry = Collections.max(authorWithCount.entrySet(), Map.Entry.comparingByValue());
        return new ReportDTO(reportCreateDTO.getDateFrom(), reportCreateDTO.getDateTo(),
                postCount, maxEntry.getKey(), maxEntry.getValue());
    }
}
