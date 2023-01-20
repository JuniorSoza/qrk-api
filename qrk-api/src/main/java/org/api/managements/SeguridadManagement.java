package org.api.managements;

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

    public Response getPrueba(){
        try {
            List<Prueba> pruebas = new ArrayList<>();

            pruebas.add(0,new Prueba(1,"Junior William","Anchundia Soza"));
            pruebas.add(1,new Prueba(2,"April William","Anchundia Ramirez"));
            pruebas.add(2,new Prueba(3,"Isaias William","Anchundia Ramirez"));

            if (pruebas.isEmpty()) {
                //return Response.status(Response.Status.BAD_REQUEST).tag("No hay valores en la bd").build();
                return ResponseStandarBuilder.responseSingle(Response.Status.BAD_REQUEST, "No hay resultados");
            }
            //return Response.ok().entity(pruebas).tag("Sin novidades").build();
            return ResponseStandarBuilder.responseObject(Response.Status.OK, "Sin novedades", pruebas);
        } catch (Exception e) {
            //log.error("obtenerTodo: {}", e.getMessage());
            e.printStackTrace();
            //return Response.status(Response.Status.INTERNAL_SERVER_ERROR).tag(e.toString()).build();
            return ResponseStandarBuilder.responseObject(Response.Status.INTERNAL_SERVER_ERROR, "Problemas al obtener ALL Almacen", e.getMessage());
        }
    }

    public Response postPrueba(Prueba prueba){
        try{
            this.seguridadService.create(prueba);
            return ResponseStandarBuilder.responseSingle(Response.Status.OK,"Sin novidades");
        }catch (Exception e ){
            return ResponseStandarBuilder.responseObject(Response.Status.INTERNAL_SERVER_ERROR, "Problemas al obtener ALL Almacen", e.getMessage());
        }
    }
}
