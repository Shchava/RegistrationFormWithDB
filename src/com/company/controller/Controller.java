package com.company.controller;

import com.company.model.Model;
import com.company.model.dao.DaoFactory;
import com.company.model.dao.NoteBookDao;
import com.company.model.dao.impl.JDBCDaoFactory;
import com.company.model.entity.NotUniqueLoginException;
import com.company.model.entity.NoteBook;
import com.company.view.View;

import java.sql.DriverManager;
import java.util.Scanner;

/**
 * Created by student on 26.09.2017.
 */
public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void processUser() {
        Scanner sc = new Scanner(System.in);
        InputNoteNoteBook inputNoteNoteBook = new InputNoteNoteBook(view, sc);
        inputNoteNoteBook.inputNote();

        NoteBook noteBook = getNoteBook(inputNoteNoteBook);
        try(NoteBookDao dao =  DaoFactory.getInstance().createNoteBookDao()) {
            dao.create(noteBook);

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(noteBook);
    }

    private NoteBook getNoteBook(InputNoteNoteBook inputNoteNoteBook) {
        NoteBook noteBook = null;
        while(true) {
            try {
                noteBook = new NoteBook(inputNoteNoteBook.getFirstName(),
                        inputNoteNoteBook.getLoginData());
                break;
            } catch (NotUniqueLoginException e) {
                e.printStackTrace();
                System.out.println("Not Unique Login " + e.getLoginData());
                inputNoteNoteBook.inputLogin();
            }
        }
        return noteBook;
    }
}
