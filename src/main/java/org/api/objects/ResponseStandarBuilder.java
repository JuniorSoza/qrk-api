package org.api.objects;

import javax.ws.rs.core.Response;
import java.util.Optional;

public class ResponseStandarBuilder {

    public static Response responseSingle(Response.Status status, String message){
        return Response.status(status)
                .entity(new ServerResponse(status.getStatusCode(), status.name(), message)).build();
    }

    public static Response responseObject(Response.Status status, String message, Object entity){
        return Response.status(status)
                .entity(new ServerResponse(status.getStatusCode(), status.name(), message, entity)).build();
    }

    public static Response responseVDI(Object entity){
        return Response.status(Response.Status.OK).entity(entity).build();
    }

    public static Response responseErrorException(Exception e){
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(new ServerResponse(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(),
                        Response.Status.INTERNAL_SERVER_ERROR.name(),
                        "Se encontraron problemas en la ejecución, si se repite contacte con el Area de TI",
                        e.getCause().toString().concat(":").concat(e.getMessage()))).build();
    }

    public static Response responseNullSingle(Object entity){
        return Optional.ofNullable(entity)
                .map(result -> responseSingle(Response.Status.OK, "Agregar mensaje"))
                .orElse(responseSingle(Response.Status.BAD_REQUEST, "Agregar mensaje"));
    }

    public static Response responseNullObject(Object entity, String nameEntity){
        return Optional.ofNullable(entity)
                .map(result -> responseObject(Response.Status.OK, "Agregar mensaje",entity))
                .orElse(responseObject(Response.Status.BAD_REQUEST, "Agregar mensaje",entity));
    }

}
