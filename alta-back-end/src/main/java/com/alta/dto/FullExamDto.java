package com.alta.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FullExamDto {
    private int id;
    private String name;
    private LocalDateTime createdAt;
    private List<StudentDto> students = new ArrayList<>();
    private List<? extends TaskDto> tasks = new ArrayList<>();
}
