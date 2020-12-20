package com.learning.mynotepad.manager;

import com.learning.mynotepad.DAO.MyNoteDAO;
import com.learning.mynotepad.api.MyNote;
import org.skife.jdbi.v2.sqlobject.CreateSqlObject;

public abstract class MyNoteManager {

    @CreateSqlObject
    abstract MyNoteDAO myNoteDAO();

    public void createNote(MyNote note) {
        System.out.println("Function Reached");
        myNoteDAO().createNote(note);
        System.out.println("Function Reached");
    }

    public MyNote getNote(String title){
        return myNoteDAO().getNote(title);
    }

    public void updateNote(String title, MyNote note){
        myNoteDAO().updateNote(title,note);
    }

    public void deleteNote(String title) {
        myNoteDAO().deleteNote(title);
    }
}
