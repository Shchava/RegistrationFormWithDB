package com.company.model.dao;

import com.company.model.dao.impl.JDBCDaoFactory;

public interface DaoFactory {

    NoteBookDao createNoteBookDao();

    public static DaoFactory getInstance(){
        return new JDBCDaoFactory();
    }
}
