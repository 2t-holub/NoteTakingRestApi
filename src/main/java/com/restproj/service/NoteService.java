package com.restproj.service;

import com.restproj.dao.NoteRepositoryRealImpl;
import com.restproj.model.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {
    @Autowired
    private NoteRepositoryRealImpl noteRepository;

    public Note save(Note note){
        note.setId(null);
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
