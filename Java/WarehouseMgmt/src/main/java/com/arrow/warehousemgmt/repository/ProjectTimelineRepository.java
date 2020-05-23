package com.arrow.warehousemgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arrow.warehousemgmt.model.ProjectTimeline;

@Repository
public interface ProjectTimelineRepository extends JpaRepository<ProjectTimeline,Long> {

}
