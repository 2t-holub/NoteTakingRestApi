package com.restproj.service;

import com.restproj.dao.NoteRepository;
import com.restproj.model.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class NoteService {
    @Autowired
    private NoteRepository noteRepository;

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

    public List<Note> findAll(Long userId){
        return noteRepository.findAll()
                .stream()
                .filter(note -> note.getUser().getId().equals(userId))
                .collect(Collectors.toList());
    }
}
