package com.android.mobileappserver.Report;

import com.android.mobileappserver.Story.StoryDTO;
import com.android.mobileappserver.Story.StoryModel;
import com.android.mobileappserver.Story.StoryService;
import com.android.mobileappserver.User.UserDTO;
import com.android.mobileappserver.User.UserModel;
import com.android.mobileappserver.User.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportService {
    private final UserService userService;
    private final StoryService storyService;

    public ReportService(UserService userService, StoryService storyService){
        this.userService = userService;
        this.storyService = storyService;
    }

    @Transactional
    public ReportDTO createReport(Long dateFrom, Long dateTo){
        List<StoryModel> stories = storyService.getStoriesByDate(dateFrom, dateTo);
        int postCount = stories.size();
        Map<Long, Integer> authorWithCount = new HashMap<>();
        for (var story: stories) {
            Long authorId = story.getUser().getId();
            if (authorWithCount.containsKey(authorId)) {
                // Если автор уже есть, увеличиваем количество историй
                authorWithCount.put(authorId, authorWithCount.get(authorId) + 1);
            } else {
                // Если автора еще нет в мапе, добавляем его с количеством 1
                authorWithCount.put(authorId, 1);
            }
        }
        Map.Entry<Long, Integer> maxEntry = Collections.max(authorWithCount.entrySet(), Map.Entry.comparingByValue());
        UserModel mostPostAuthor = userService.getUserById(maxEntry.getKey());
        return new ReportDTO(dateFrom, dateTo, postCount, new UserDTO(mostPostAuthor), maxEntry.getValue(),
                mostPostAuthor.getStories().stream().map(
                        StoryDTO::new
                ).toList());
    }
}
