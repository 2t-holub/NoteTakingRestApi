package com.restproj.dao;

import com.restproj.model.Note;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
@Primary
public class NoteRepositoryRealImpl implements NoteRepository {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Note save(Note note) {
        entityManager.persist(note);
        return note;
    }

    @Override
    public Note findById(Long id) {
        return entityManager.find(Note.class, id);
    }

    @Override
    public Note update(Note note) {
        entityManager.merge(note);
        return note;
    }

    @Override
    public void delete(Note note) {
        entityManager.remove(note);
    }

    @Override
    public List<Note> findAll() {
       return entityManager.createQuery("SELECT n FROM Note n").getResultList();
    }
}
