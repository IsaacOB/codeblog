package com.spring.codeblog.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "TB_POST")
@Getter
@Setter
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String author;
    private LocalDate createdAt;
    private String text;

}
