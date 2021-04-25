package com.restproj.dao;

import com.restproj.model.Note;

import java.util.List;

public interface NoteRepository {

    Note save(Note note);

    Note findById(Long id);

    Note update(Note note);

    void delete(Note note);

    List<Note> findAll();
}
