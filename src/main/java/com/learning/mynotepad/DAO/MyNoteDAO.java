package com.learning.mynotepad.DAO;

import com.learning.mynotepad.api.MyNote;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

public interface MyNoteDAO {

    @SqlUpdate("insert into note (title,content) values (:note.title,:note.content)")
    public void create(@BindBean("note") MyNote note);

}
