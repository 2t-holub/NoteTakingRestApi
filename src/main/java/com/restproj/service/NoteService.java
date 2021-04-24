package com.restproj.service;

import com.restproj.dao.NoteRepository;
import com.restproj.model.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {
    @Autowired
    private NoteRepository noteRepository;

    public Note save(Note note){
        return noteRepository.save(note);
    }

    public Note findById(Long id){
        return noteRepository.findById(id);
    }

    public Note update(Note note){
        return noteRepository.update(note);
    }

    public void delete(Note note){
        noteRepository.delete(note);
    }

    public List<Note> findAll(){
        return noteRepository.findAll();
    }
}
