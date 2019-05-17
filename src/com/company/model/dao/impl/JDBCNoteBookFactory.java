package com.company.model.dao.impl;

import com.company.model.dao.NoteBookDao;
import com.company.model.entity.NotUniqueLoginException;
import com.company.model.entity.NoteBook;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.sql.Connection;

public class JDBCNoteBookFactory implements NoteBookDao {

    private Connection connection;

    public JDBCNoteBookFactory(Connection connection){
        this.connection = connection;
    };

    @Override
    public void create(NoteBook entity) {
        try (Statement ps = connection.createStatement()){
            ps.execute("insert into nooteBooks values('"+ entity.getLoginData() + "','" + entity.getFirstName() + "');");
        }catch(SQLException ex){
            System.err.print(ex);
        }
    }

    @Override
    public NoteBook findByKey(String login) {
        NoteBook requested = null;
        try (Statement ps = connection.createStatement()){
            ResultSet rs =  ps.executeQuery("select * from nooteBooks where login like '" + login + "';");
            if(rs.next()){
                requested = getNoteBookFromRS(rs);
            }else{
                requested = null;
            }
        }catch(SQLException ex){
            System.err.print(ex);
        }
        return requested;
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
        connection.close();
    }

    private NoteBook getNoteBookFromRS(ResultSet rs) throws SQLException {
        return new NoteBook(rs.getString(1), rs.getString(2));
    }

}
