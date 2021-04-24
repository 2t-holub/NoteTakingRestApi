package com.restproj.controller;


import com.restproj.model.Note;
import com.restproj.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
public class NoteController {
    @Autowired
    private NoteService noteService;

    @GetMapping
    public List<Note> getAll(){
        return noteService.findAll();
    }

    @GetMapping("/{id}")
    public Note getById(@PathVariable(name = "id") Long id){
        return noteService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Note create(@RequestBody Note note){
        return noteService.save(note);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Note update(@PathVariable Long id, @RequestBody Note note){
        if(!id.equals(note.getId())){
            throw new IllegalStateException("Path variable id and real note id are different!");
        }
        return noteService.update(note);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        Note note = noteService.findById(id);
        noteService.delete(note);
    }
}
