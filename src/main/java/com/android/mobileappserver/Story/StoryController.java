package com.android.mobileappserver.Story;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/story")
public class StoryController {
    private final StoryService storyService;

    public StoryController(StoryService storyService) {
        this.storyService = storyService;
    }

    @PostMapping({"/create"})
    public StoryDTO create(@RequestBody StoryDTO storyDTO) {
        return new StoryDTO(storyService.insert(storyDTO));
    }

    @PutMapping("/update/{id}")
    public StoryDTO update(@PathVariable("id") Long id, @RequestBody StoryDTO storyDTO){
        return new StoryDTO(storyService.update(storyDTO));
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) throws Exception{
        storyService.delete(id);
    }

    @GetMapping("/get/{id}")
    public StoryDTO get(@PathVariable("id") Long id){
        return new StoryDTO(storyService.getById(id));
    }

    @GetMapping("/getAll")
    public List<StoryDTO> getAll(@RequestParam("page") int page,
                                 @RequestParam("size") int size) {
        return storyService.getAllStoryPaged(page, size).stream().map(
                StoryDTO::new
        ).toList();
    }
}
