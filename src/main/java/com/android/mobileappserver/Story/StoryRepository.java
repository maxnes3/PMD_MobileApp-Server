package com.android.mobileappserver.Story;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoryRepository extends JpaRepository<StoryModel, Long> {
    Page<StoryModel> findAllByUserId(Long userIdб, Pageable pageable);
}
