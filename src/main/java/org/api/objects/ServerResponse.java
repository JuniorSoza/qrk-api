package org.api.objects;

public class ServerResponse {

    private int key;
    private String status;
    private String mensaje;
    private Object respuesta;

    public ServerResponse() {
    }

    public ServerResponse(int key, String status, String mensaje) {
        this.key = key;
        this.status = status;
        this.mensaje = mensaje;
    }

    public ServerResponse(int key, String status, String mensaje, Object respuesta) {
        this.key = key;
        this.status = status;
        this.mensaje = mensaje;
        this.respuesta = respuesta;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Object getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(Object respuesta) {
        this.respuesta = respuesta;
    }

}