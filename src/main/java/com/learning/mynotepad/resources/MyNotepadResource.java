package com.learning.mynotepad.resources;

import com.learning.mynotepad.api.MyNote;
import com.learning.mynotepad.manager.MyNoteManager;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/MyNote")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MyNotepadResource {

    private final MyNoteManager myNoteManager;

    public MyNotepadResource(MyNoteManager myNoteManager) {
        this.myNoteManager = myNoteManager;
    }


    @POST
    @Path("/Create")
    public Response createNote(@NotNull @Valid MyNote note){
        myNoteManager.createNote(note);
        return Response.ok().build();
    }

    @PUT
    @Path("/Update")
    public Response updateNote(@QueryParam("title") @NotNull String title,@NotNull @Valid MyNote note ){
        System.out.println("Here");
        myNoteManager.updateNote(title,note);
        return Response.ok().build();
    }

    @DELETE
    @Path("/Delete")
    public Response deleteNote(@QueryParam("title") @NotNull String title){
        System.out.println("Going to delete" + title);
        myNoteManager.deleteNote(title);
        return Response.accepted().build();
    }

    @GET
    @Path("/Read")
    public MyNote readNote(@QueryParam("title") String title){
        System.out.println("??????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????");
        System.out.println("Title : " + title);
        MyNote note = myNoteManager.getNote(title);
        return note;
    }
}
