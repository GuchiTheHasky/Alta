package com.alta.service.impl;

import com.alta.dto.TopicDto;
import com.alta.entity.Topic;
import com.alta.mapper.TopicMapper;
import com.alta.repository.TopicRepository;
import com.alta.service.TopicService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DefaultTopicService implements TopicService {
    private final TopicRepository topicRepository;
    private final TopicMapper topicMapper;

    @Override
    public List<TopicDto> findAll() {
        return topicRepository.findAll().stream()
                .map(topicMapper::toTopicDto)
                .collect(Collectors.toList());
    }

    @Override
    public Topic save(Topic topicDto) {
        return topicRepository.save(topicDto);
    }

    @Override
    public List<Topic> getTasksFromTopics(List<Integer> topicIds) {
        return topicRepository.findAllById(topicIds);
    }
}
