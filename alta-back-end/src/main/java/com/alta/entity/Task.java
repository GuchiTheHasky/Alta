package com.alta.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Data
@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name="image_path")
    private String imagePath;

    private String level;
    private String text;

    @Column(name="text_html")
    private String textHtml;
    private String answer;

    @ManyToOne
    @JsonBackReference
    @JdbcTypeCode(SqlTypes.JSON)
    @JoinColumn(name = "topic_id", referencedColumnName = "id" )
    private Topic topic;

    @ManyToOne
    @JsonManagedReference
    @JdbcTypeCode(SqlTypes.JSON)
    @JoinColumn(name = "student_id", referencedColumnName = "id" )
    private Student student;

}
