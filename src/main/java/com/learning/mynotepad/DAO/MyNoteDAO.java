package com.learning.mynotepad.DAO;

import com.learning.mynotepad.mapper.MyNoteMapper;
import com.learning.mynotepad.api.MyNote;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;


@RegisterMapper(MyNoteMapper.class)
public interface MyNoteDAO {

    @SqlUpdate("insert into note (title,content) values (:note.title,:note.content) ;")
    void createNote(@BindBean("note") MyNote note);

    @SqlQuery("select * from note where title = :title ;")
    MyNote getNote(@Bind("title") String title);

    @SqlUpdate("update note set title = :note.title , content = :note.content where title = :title;")
    void updateNote(@Bind("title") String title,@BindBean("note") MyNote note);

    @SqlUpdate("delete from note where title = :title ;")
    void deleteNote(@Bind("title") String title);
}
