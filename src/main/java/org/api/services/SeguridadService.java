package org.api.services;

import org.api.objects.Prueba;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
public class SeguridadService {

    @Transactional
    public void create(Prueba prueba){

    }
}
