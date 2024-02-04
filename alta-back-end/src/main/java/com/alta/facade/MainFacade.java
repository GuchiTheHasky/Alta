package com.alta.facade;

import com.alta.dto.StudentDto;
import com.alta.dto.TaskDto;
import com.alta.dto.TopicDto;

import java.util.List;
import java.util.Map;

public interface MainFacade {
//    /**
//     * Fetches a list of unfinished tasks based on Students IDs and IDs of Topic objects.
//     * @param studentsIds : The List of Student objects IDs on the basis of which tasks should be selected.
//     * @param topicsIds : List of Topic objects IDs on the basis of which tasks should be selected.
//     * @return List of TaskDto objects representing the tasks that match the information provided.
//     */


    /**
     * Updates the list of tasks of Student object and retrieve list of tasks that match ids specified.
     *
     * @param studentsDto : List of students which tasks should be updated.
     * @param tasks       : List of tasks ids that should be set.
     */
    Map<String, List<TaskDto>> updateStudentTasksAndRetrieveDto(List<StudentDto> studentsDto, List<TaskDto> tasks);

    /**
     * Returns a list of all Student objects available.
     *
     * @return A list of StudentDto objects representing the available students.
     */
    List<StudentDto> findAllStudents();

    /**
     * Updates an existing Task object with the provided information.
     *
     * @param taskDto : An object containing the updated information for the task.
     * @return An object representing the updated task.
     */
    TaskDto updateTask(TaskDto taskDto);

    /**
     * Returns a list of all Topic objects available.
     *
     * @return A list of TopicDto objects representing the available topics.
     */
    List<TopicDto> findAllTopics();

    List<TaskDto> findTasksCompletedByAtLeastOneStudent(List<TopicDto> topics, List<StudentDto> studentsDto);

    List<TaskDto> findUnfinishedTasks(List<TopicDto> topics, List<StudentDto> studentsDto);
}
