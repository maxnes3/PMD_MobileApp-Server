package com.android.mobileappserver.Story;

import com.android.mobileappserver.User.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

@Service
public class StoryService {
    private final UserService userService;
    private final StoryRepository storyRepository;

    public StoryService(UserService userService, StoryRepository storyRepository){
        this.userService = userService;
        this.storyRepository = storyRepository;
    }

    @Transactional(readOnly = true)
    public StoryModel getById(Long id){
        return storyRepository.getReferenceById(id);
    }

    @Transactional
    public StoryModel insert(StoryDTO storyDTO){
        var user = userService.getUserById(storyDTO.getUserId());
        StoryModel story = new StoryModel(storyDTO.getTitle(), storyDTO.getDescription(), storyDTO.getCover(), user);
        return storyRepository.save(story);
    }

    @Transactional
    public StoryModel update(StoryDTO storyDTO){
        final StoryModel story = getById(storyDTO.getId());
        story.setTitle(storyDTO.getTitle());
        story.setDescription(storyDTO.getDescription());
        story.setCover(storyDTO.getCover());
        return storyRepository.save(story);
    }

    @Transactional
    public void delete(Long id) throws Exception{
        try{
            final StoryModel curStory = getById(id);
            storyRepository.delete(curStory);
        }catch(Exception ex){
            throw new Exception("Ошибка при удалении story с id: " + id);
        }
    }

    @Transactional
    public Page<StoryModel> getAllStoryPaged(int page, int size){
        return storyRepository.findAll(PageRequest.of(page - 1, size));
    }
}
