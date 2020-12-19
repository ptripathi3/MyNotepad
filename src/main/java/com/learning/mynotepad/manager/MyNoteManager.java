package com.learning.mynotepad.manager;

import com.learning.mynotepad.DAO.MyNoteDAO;
import com.learning.mynotepad.api.MyNote;
import org.skife.jdbi.v2.sqlobject.CreateSqlObject;

public abstract class MyNoteManager {

    @CreateSqlObject
    abstract MyNoteDAO myNoteDAO();

    public void createNote(MyNote note) {
        System.out.println("Function Reached");
        myNoteDAO().create(note);
        System.out.println("Function Reached");
    }
}
