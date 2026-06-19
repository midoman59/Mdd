package com.openclassrooms.mddapi.topic.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.openclassrooms.mddapi.topic.entity.TopicEntity;

@Repository
public interface TopicRepository extends JpaRepository<TopicEntity, UUID> {
}
