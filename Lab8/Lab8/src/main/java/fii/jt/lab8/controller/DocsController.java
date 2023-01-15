package fii.jt.lab8.controller;


import fii.jt.lab8.model.Docs;
import fii.jt.lab8.service.DocsService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/docs")
public class DocsController {
    @Inject
    private DocsService docsService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public final List<Docs> getDocs(){
        return docsService.getDocs();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public final void add(Docs doc){
        docsService.add(doc);
    }

    @PATCH
    @Consumes(MediaType.APPLICATION_JSON)
    public final void update(Docs doc){
        docsService.update(doc);
    }

    @DELETE
    @Path("/{id}")
    public final void delete(@PathParam("id") Long id){
        docsService.delete(id);
    }
}
