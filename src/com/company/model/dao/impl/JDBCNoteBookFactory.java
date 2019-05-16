package com.company.model.dao.impl;

import com.company.model.dao.NoteBookDao;
import com.company.model.entity.NoteBook;

import java.util.List;
import java.sql.Connection;

public class JDBCNoteBookFactory implements NoteBookDao {

    private Connection connection;

    public JDBCNoteBookFactory(Connection connection){
        this.connection = connection;
    };

    @Override
    public void create(NoteBook entity) {

    }

    @Override
    public NoteBook findById(int id) {
        return null;
    }

    @Override
    public List<NoteBook> findAll() {
        return null;
    }

    @Override
    public void update(NoteBook entity) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void close() throws Exception {

    }
}
