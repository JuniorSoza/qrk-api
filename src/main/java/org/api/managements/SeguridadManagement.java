package org.api.managements;

import org.api.models.Persona;
import org.api.objects.Prueba;
import org.api.objects.ResponseStandarBuilder;
import org.api.services.SeguridadService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class SeguridadManagement {

    @Inject
    SeguridadService seguridadService;

    public Response getAllPrueba(){
        try {
            /*List<Prueba> pruebas = new ArrayList<>();
            pruebas.add(0,new Prueba(1,"Junior William","Anchundia Soza"));
            pruebas.add(1,new Prueba(2,"April William","Anchundia Ramirez"));
            pruebas.add(2,new Prueba(3,"Isaias William","Anchundia Ramirez"));
            */

            List<Persona> personas = new ArrayList<>();
            personas.addAll(this.seguridadService.getAll());
            if (personas.isEmpty()) {
                return ResponseStandarBuilder.responseSingle(Response.Status.BAD_REQUEST, "No hay resultados");
            }
            return ResponseStandarBuilder.responseObject(Response.Status.OK, "Sin novedades",personas );
        } catch (Exception e) {
            //log.error("obtenerTodo: {}", e.getMessage());
            e.printStackTrace();
            return ResponseStandarBuilder.responseObject(Response.Status.INTERNAL_SERVER_ERROR, "Problemas al obtener ALL ", e.getMessage());
        }
    }

    public Response getPersonaForId(Long id){
        try{
            Persona persona = this.seguridadService.getPersonaForId(id);
            if(persona.getId() == null){
                return ResponseStandarBuilder.responseSingle(Response.Status.BAD_REQUEST, "No hay resultados");
            }
            return ResponseStandarBuilder.responseObject(Response.Status.OK, "Creado sin novedades",persona );
        }catch (Exception e){
            e.printStackTrace();
            return ResponseStandarBuilder.responseObject(Response.Status.INTERNAL_SERVER_ERROR, "Problemas al obtener ALLForId ", e.getMessage());
        }
    }

    public Response postPrueba(Persona persona){
        try{
            this.seguridadService.create(persona);
            return ResponseStandarBuilder.responseSingle(Response.Status.OK,"Sin novidades");
        }catch (Exception e ){
            return ResponseStandarBuilder.responseObject(Response.Status.INTERNAL_SERVER_ERROR, "Problemas al CREAR LA PERSONA", e.getMessage());
        }
    }

    public Response putPrueba(Persona persona){
        try{
            this.seguridadService.update(persona);
            return ResponseStandarBuilder.responseSingle(Response.Status.OK,"Actualizado sin novidades");
        }catch (Exception e ){
            return ResponseStandarBuilder.responseObject(Response.Status.INTERNAL_SERVER_ERROR, "Problemas al CREAR LA PERSONA", e.getMessage());
        }
    }

    public Response deletePrueba(Long id){
        try{
            Persona persona = this.seguridadService.getPersonaForId(id);
            if(persona.getId() == null){
                return ResponseStandarBuilder.responseSingle(Response.Status.BAD_REQUEST, "El usuario no existe");
            }
            this.seguridadService.delete(persona);
            return ResponseStandarBuilder.responseSingle(Response.Status.OK,"Eliminado sin novidades");
        }catch (Exception e ){
            return ResponseStandarBuilder.responseObject(Response.Status.INTERNAL_SERVER_ERROR, "Problemas al eliminar LA PERSONA", e.getMessage());
        }
    }
}
