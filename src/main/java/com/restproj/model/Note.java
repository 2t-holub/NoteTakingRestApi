package com.restproj.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "note")
public class Note {
    @Id
    @GeneratedValue
    @Column(name = "note_id")
    private Long id;

    @Column(name = "note_text", nullable = false)
    private String text;

    @Column(name = "note_title", nullable = false)
    private String title;

    @Column(name = "note_time", nullable = false)
    private Date actualTime;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name="author")
    private User user;
}
