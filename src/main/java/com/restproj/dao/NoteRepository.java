package com.restproj.dao;

import com.restproj.model.Note;

import java.util.List;

public interface NoteRepository {

    public Note save(Note note);

    public Note findById(Long id);

    public Note update(Note note);

    public void delete(Note note);

    public List<Note> findAll();
}
