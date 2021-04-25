package com.restproj.dao;

import com.restproj.model.Note;
import com.restproj.model.User;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Component
public class NoteRepositoryFakeImpl implements NoteRepository {
    private static Map<Long, Note> notes = new HashMap<>();

    public NoteRepositoryFakeImpl() {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Etc/UTC"));
            notes.put(1L, new Note(1L, "Hello!", "Hello title", simpleDateFormat.parse("2021-05-12 13:41:00"), new User()));
            notes.put(2L, new Note(2L, "Hello, Spring", "Spring", simpleDateFormat.parse("2021-03-01 10:27:30"), new User()));
        }catch(ParseException ex){
            System.out.println("Exception in data generation:\n" + ex);
        }
    }

    @Override
    public Note save(Note note) {
        notes.put(note.getId(),note);
        return note;
    }

    @Override
    public Note findById(Long id) {
        return notes.get(id);
    }

    @Override
    public Note update(Note note) {
        notes.put(note.getId(), note);
        return note;
    }

    @Override
    public void delete(Note note) {
        notes.remove(note.getId());
    }

    @Override
    public List<Note> findAll() {
       return new ArrayList<Note>(notes.values());
    }
}
