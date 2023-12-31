package com.alta.service;

import com.alta.dto.TaskDto;
import com.alta.dto.TopicDto;
import com.alta.entity.Topic;
import java.util.List;

/**
 * Interface for managing the Topic data.
 * Provides functionality to return, save, update, and delete Topic objects.
 */

public interface TopicService { // todo: check documentation.

    /**
     * Returns a list of all Topic objects available.
     *
     * @return A list of TopicDto objects representing the available topics.
     */
    List<TopicDto> findAll();

    Topic save(Topic topicDto);

    List<Topic> getTasksFromTopics(List<Integer> topicIds);

}
