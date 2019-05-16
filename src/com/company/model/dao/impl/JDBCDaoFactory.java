package com.company.model.dao.impl;

import com.company.model.dao.DaoFactory;
import com.company.model.dao.NoteBookDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCDaoFactory implements DaoFactory {

    @Override
    public NoteBookDao createNoteBookDao() {
        return new JDBCNoteBookFactory(getConnection());
    }

    private Connection getConnection(){
        try {
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mycardb",
                    "root" ,
                    "123123aa" );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
