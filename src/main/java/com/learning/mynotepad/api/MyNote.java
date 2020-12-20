package com.learning.mynotepad.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;

public class MyNote {

    @NotNull
    @JsonProperty("title")
    String title;
    @NotNull
    @JsonProperty("content")
    String content;

    public MyNote() {
    }

    public MyNote(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) { this.title = title; }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "title : "+ this.getTitle() + "\ncontent : "+this.getContent();
    }

}
