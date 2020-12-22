package com.learning.mynotepad.manager;

import com.learning.mynotepad.DAO.MyNoteDAO;
import com.learning.mynotepad.api.MyNote;
import org.skife.jdbi.v2.sqlobject.CreateSqlObject;

import java.util.List;

public abstract class MyNoteManager {

    @CreateSqlObject
    abstract MyNoteDAO myNoteDAO();

    public void createNote(MyNote note) {
        myNoteDAO().createNote(note);
    }

    public MyNote readNote(String title) {
        return myNoteDAO().getNote(title);
    }

    public void updateNote(String title, MyNote note) {
        myNoteDAO().updateNote(title, note);
    }

    public void deleteNote(String title) {
        myNoteDAO().deleteNote(title);
    }

    public List<MyNote> searchNote(String keyWord) {
        return myNoteDAO().searchNote("%" + keyWord + "%");
    }

    public List<MyNote> allNote() {
        return myNoteDAO().getAllNotes();
    }
}
