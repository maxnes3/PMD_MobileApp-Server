package com.android.mobileappserver.Story;

public class StoryNotFoundException extends RuntimeException{
    public StoryNotFoundException(Long id) {
        super(String.format("Story with id [%s] is not found", id));
    }
}