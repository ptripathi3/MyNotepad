package com.learning.mynotepad.api;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

//@JsonInclude(JsonInclude.Include.NON_NULL)
public class MyNote {

    @NotNull
    @JsonProperty("title")
    String title;
    @NotNull
    @JsonProperty("content")
    String content;


    public String getTitle() {
        return title;
    }

    public MyNote(){ }

    public MyNote(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @JsonProperty
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty
    public void setContent(String content) {
        this.content = content;
    }

    @JsonProperty
    public String getContent() {
        return content;
    }

    public String toString(MyNote note){
        return note.getTitle()+ note.getContent();
    }
}
