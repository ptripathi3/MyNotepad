package com.learning.mynotepad.resources;

import com.learning.mynotepad.api.MyNote;
import com.learning.mynotepad.manager.MyNoteManager;
import io.swagger.annotations.ApiParam;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/note")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MyNotepadResource {

    private final MyNoteManager myNoteManager;

    public MyNotepadResource(MyNoteManager myNoteManager) {
        this.myNoteManager = myNoteManager;
    }


    @POST
    @Path("/Create")
    public Response createNote(@ApiParam @NotNull @Valid MyNote note){
//        MyNote note =  new MyNote("Hello","Good day");
        myNoteManager.createNote(note);
        return Response.ok().build();
    }

    @GET
    @Path("/hello")
    public Response hello(){
        System.out.println("Here");
        return Response.ok().build();

    }


    @GET
    @Path("/Read")
    public void readNote(@QueryParam("Title") String title){
        System.out.println("??????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????");
        System.out.println("Title : " + title);
        MyNote note =  new MyNote("Hello","Good day");
        myNoteManager.createNote(note);
    }
}
