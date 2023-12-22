package com.android.mobileappserver.Story;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StoryRepository extends JpaRepository<StoryModel, Long> {
}
