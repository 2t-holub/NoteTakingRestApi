package com.restproj.controller;

import com.restproj.model.Note;
import com.restproj.model.Role;
import com.restproj.model.User;
import com.restproj.service.NoteService;
import com.restproj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/notes")
public class NoteController {
    @Autowired
    private NoteService noteService;

    @Autowired
    private UserService userService;

    @GetMapping
    public List<Note> getAll(){
        return noteService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Note> getById(@PathVariable(name = "id") Long id, Principal principal){
        User user = userService.findByLogin(principal.getName());
        Note note = noteService.findById(id);
        if(note == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        if(user.equals(note.getUser()) || user.getRole().equals(Role.ADMIN)) {
            return new ResponseEntity<>(noteService.findById(id), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Note create(@RequestBody Note note, Principal principal){
        User user = userService.findByLogin(principal.getName());
        note.setUser(user);
        return noteService.save(note);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Note> update(@PathVariable Long id, @RequestBody Note note, Principal principal){
        if(!id.equals(note.getId())){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        User user = userService.findByLogin(principal.getName());
        Note oldNote = noteService.findById(id);
        if(oldNote == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        if (user.equals(oldNote.getUser()) || user.getRole().equals(Role.ADMIN)){
            return new ResponseEntity(noteService.update(note), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id, Principal principal){
        User user = userService.findByLogin(principal.getName());
        Note note = noteService.findById(id);
        if(note == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        if(user.equals(note.getUser()) || user.getRole().equals(Role.ADMIN)){
            noteService.delete(note);
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.FORBIDDEN);
    }
}
