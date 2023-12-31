package com.alta.service;

import com.alta.dto.StudentDto;
import com.alta.entity.Student;

import java.util.List;

/**
 * Interface for managing the Student data.
 * Provides functionality to return, save, update, and delete Student objects.
 */

public interface StudentService { // todo: check documentation.

    /**
     * Returns a list of all Student objects available.
     *
     * @return A list of StudentDto objects representing the available students.
     */
    List<StudentDto> findAll();

    /**
     * Gets a Student object based on its unique identifier.
     * @param studentId : The unique identifier of the Student object to be found.
     */
    Student findById(int studentId);

    void assigneTasks(int id, List<Integer> tasks);
}
