package com.android.mobileappserver.Story;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StoryRepository extends JpaRepository<StoryModel, Long> {
    Page<StoryModel> findAllByUserId(Long userIdб, Pageable pageable);

    @Query("SELECT s FROM _story s WHERE s.dateFrom = :dateFrom AND s.dateTo = :dateTo")
    List<StoryModel> findStoriesBetweenDates(@Param("dateFrom") Long dateFrom, @Param("dateTo") Long dateTo);
}
