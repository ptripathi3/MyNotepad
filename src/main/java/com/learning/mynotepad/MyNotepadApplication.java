package com.learning.mynotepad;

import com.learning.mynotepad.resources.MyNotepadResource;
import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Environment;

public class MyNotepadApplication extends Application<MyNotepadConfiguration> {

    public static void main(String[] args) throws Exception {
        new MyNotepadApplication().run(args);
    }


    public void run(MyNotepadConfiguration myNotepadConfiguration, Environment environment) throws Exception {
        final MyNotepadResource myNotepadResource = new MyNotepadResource();
        environment.jersey().register(myNotepadResource);
    }

//    public void run(Configuration configuration, Environment environment) throws Exception {
//        final MyNotepadResource myNotepadResource = new MyNotepadResource();
//        environment.jersey().register(myNotepadResource);
//    }
}
