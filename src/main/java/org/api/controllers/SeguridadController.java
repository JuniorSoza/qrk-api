package org.api.controllers;

import org.api.managements.SeguridadManagement;
import org.api.objects.Prueba;
import org.eclipse.microprofile.metrics.annotation.Timed;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("seguridad")
@RequestScoped
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Timed
public class SeguridadController {

    @Inject
    SeguridadManagement seguridadManagement;

    @GET
    @Operation(summary = "Obtener todos", description = "Obtener todos")
    @APIResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(type = SchemaType.ARRAY,
            implementation = Prueba.class, name = "Prueba"), mediaType = MediaType.APPLICATION_JSON))
    @APIResponse(responseCode = "400", description = "Bad Request")
    @APIResponse(responseCode = "500", description = "Internal Server Error")
    public Response getPrueba() {
        return this.seguridadManagement.getPrueba();
    }

    @GET
    @Path("prueba2/{id}")
    @Operation(summary = "Obtener todos por id", description = "Obtener todos por id")
    @APIResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(type = SchemaType.ARRAY,
            implementation = Prueba.class, name = "Prueba"), mediaType = MediaType.APPLICATION_JSON))
    @APIResponse(responseCode = "400", description = "Bad Request")
    @APIResponse(responseCode = "500", description = "Internal Server Error")
    public Response myPatch(@PathParam("id") String id){
        return Response.ok(id).build();
    }

    @POST
    @Operation(summary = "Crear", description = "Crea un nuevo")
    @RequestBody(content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(type = SchemaType.OBJECT,
            implementation = Prueba.class)), description = "prueba VM", required = true)
    @APIResponse(responseCode = "200", description = "OK")
    @APIResponse(responseCode = "400", description = "Bad Request")
    @APIResponse(responseCode = "500", description = "Internal Server Error")
    public Response crearPrueba(Prueba prueba){
        return this.seguridadManagement.postPrueba(prueba);
    }
}
