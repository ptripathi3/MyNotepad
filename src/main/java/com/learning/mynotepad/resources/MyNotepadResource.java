package com.learning.mynotepad.resources;

import com.learning.mynotepad.api.MyNote;
import com.learning.mynotepad.manager.MyNoteManager;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/MyNote")
@Api("MyNote")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MyNotepadResource {

    private final MyNoteManager myNoteManager;
    private static final Logger LOGGER = LoggerFactory.getLogger("MyNoteManager");

    public MyNotepadResource(MyNoteManager myNoteManager) {
        this.myNoteManager = myNoteManager;
    }


    @POST
    @Path("/Create")
    public Response createNote(@NotNull @Valid MyNote note){
        LOGGER.info("Received Create request for Note {}",note);
        myNoteManager.createNote(note);
        return Response.ok().build();
    }

    @PUT
    @Path("/Update")
    public Response updateNote(@QueryParam("title") @NotNull String title,@NotNull @Valid MyNote note ){
        LOGGER.info("Received update request for title {} to {}",title,note);
        myNoteManager.updateNote(title,note);
        return Response.ok().build();
    }

    @DELETE
    @Path("/Delete")
    public Response deleteNote(@QueryParam("title") @NotNull String title){
        LOGGER.info("Received delete request for title {}",title);
        myNoteManager.deleteNote(title);
        return Response.accepted().build();
    }

    @GET
    @Path("/Read")
    public MyNote readNote(@QueryParam("title") @NotNull String title){
        LOGGER.info("Received Read request for title {}",title);
        return myNoteManager.readNote(title);
    }

    @GET
    @Path("/Search")
    public List<MyNote> searchNote(@QueryParam("keyWord") @NotNull String keyWord){
        LOGGER.info("Received Search request for keyWord {}",keyWord);
        return myNoteManager.searchNote(keyWord);
    }

    @GET
    @Path("/All")
    public List<MyNote> getAllNote(){
        LOGGER.info("Received request to retrieve all notes");
        return myNoteManager.allNote();
    }

}
