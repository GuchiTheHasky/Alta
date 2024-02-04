package com.alta.facade.impl;

import com.alta.dto.StudentDto;
import com.alta.dto.TaskDto;
import com.alta.dto.TopicDto;
import com.alta.entity.Student;
import com.alta.entity.Task;
import com.alta.entity.Topic;
import com.alta.facade.MainFacade;
import com.alta.mapper.StudentMapper;
import com.alta.mapper.TaskMapper;
import com.alta.mapper.TopicMapper;
import com.alta.service.StudentService;
import com.alta.service.TaskService;
import com.alta.service.TopicService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DefaultMainFacade implements MainFacade {
    private final TopicService topicService;
    private final TaskService taskService;
    private final StudentService studentService;
    private final TopicMapper topicMapper;
    private final StudentMapper studentMapper;
    private final TaskMapper taskMapper;

    @Override
    public List<TaskDto> findUnfinishedTasks(List<Integer> topicsIds, List<Integer> studentsIds) {
        return filterOfUnfinishedTasks(topicsIds, studentsIds);
    }

    @Override
    @Transactional
    public Map<String, List<TaskDto>> updateStudentTasksAndRetrieveDto(List<Integer> studentsIds, List<Integer> tasksIds) { // todo rename method
           return assignTasks(studentsIds, tasksIds);
    }

    @Override
    public List<TopicDto> findAllTopics() {
        return topicService.findAll();
    }

    @Override
    public List<TaskDto> findTasksCompletedByAtLeastOneStudent(List<Integer> topicsIds, List<Integer> studentsIds) {
        return filterOfTasksCompletedByAtLeastOneStudent(topicsIds, studentsIds);
    }

    List<TaskDto> filterOfTasksCompletedByAtLeastOneStudent(List<Integer> topicsIds, List<Integer> studentsIds) {
        List<Student> students = studentService.findAllById(studentsIds);
        List<Task> completedTasks = studentService.getTasks(students);

        return taskService.getTasksCompletedByAtLeastOneStudent(topicsIds, completedTasks);
    }

    @Override
    public List<StudentDto> findAllStudents() {
        return studentService.findAll();
    }

    @Override
    public TaskDto updateTask(TaskDto taskDto) {
        return taskService.update(taskDto);
    }

    List<TaskDto> filterOfUnfinishedTasks(List<Integer> topicsIds, List<Integer> studentsIds) {
        List<Student> students = studentService.findAllById(studentsIds);
        List<Task> completedTasks = studentService.getTasks(students);

        return taskService.getUnfinishedTasks(topicsIds, completedTasks);
    }

    Map<String, List<TaskDto>> assignTasks(List<Integer> studentsIds, List<Integer> tasks) {
        List<Student> students = studentService.findAllById(studentsIds);
        List<Task> tasksToAdd = taskService.findAllById(tasks);

        return getMapOfStudentsAndTasksAssigned(students, tasksToAdd);
    }

    private Map<String, List<TaskDto>> getMapOfStudentsAndTasksAssigned(List<Student> students, List<Task> tasksToAdd) {
        Map<String, List<TaskDto>> mapOfStudentsAndTasksAssigned = new HashMap<>();

        students.forEach(student -> {
            List<Task> newTasks = taskService.excludeCompletedTasks(tasksToAdd, student);

            student.getTasks().addAll(tasksToAdd);
            studentService.save(student);

            mapOfStudentsAndTasksAssigned.put(studentMapper.toStudentDto(student).getFullName(),
                    taskMapper.toTaskDtoList(newTasks));
        });

        return mapOfStudentsAndTasksAssigned;
    }
}
