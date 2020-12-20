package com.learning.mynotepad.mapper;

import com.learning.mynotepad.api.MyNote;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MyNoteMapper implements ResultSetMapper<MyNote> {
    public MyNote map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        System.out.println(resultSet.getString("title"));
        System.out.println(resultSet.getString("content"));
        MyNote note = new MyNote(resultSet.getString("title"), resultSet.getString("content") );
        return note;
    }
}
