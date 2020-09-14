package com.projects.todo.models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date createdAt;


}
