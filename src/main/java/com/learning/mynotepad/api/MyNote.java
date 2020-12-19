package com.learning.mynotepad.api;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MyNote {

    @JsonProperty
    String title;
    @JsonProperty
    String content;

    public String getTitle() {
        return title;
    }

    public MyNote(){ }

    public MyNote(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public String toString(MyNote note){
        return note.getTitle()+ note.getContent();
    }
}
