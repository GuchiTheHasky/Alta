package com.alta.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Entity(name="student")
@Table(schema="alta")
@EqualsAndHashCode(exclude = "tasks")
@ToString(exclude = "tasks")
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_generator")
    @SequenceGenerator(name="id_generator", sequenceName = "student_id_sequence", initialValue = 1, allocationSize = 20)
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String email;
    private String grade;
    private String comment;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "students")
    private Set<Task> tasks = new HashSet<>();
}
