package org.api.services;

import org.api.models.Persona;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class SeguridadService {
    private EntityManager em;

    final Logger log = LoggerFactory.getLogger(this.getClass());

    public SeguridadService(EntityManager em) {
        this.em = em;
    }

    public List<Persona> getAll(){
        return em.createQuery("Select a from Persona a", Persona.class).getResultList();
    }

    public Persona getPersonaForId(Long id){
        Persona persona = new Persona();
        try{
            persona= em.createQuery("select a from Persona a where a.id = ?id " ,Persona.class)
                    .setParameter("id",id)
                    .getSingleResult();
        }catch (Exception e){
            log.error("getPersonaForId: {}", e.getMessage());
        }
        return persona;
    }

    @Transactional
    public void create(Persona persona){
        //Persona personaNew = new Persona();
        //personaNew.setApellidos(persona.getApellidos());
        //personaNew.setNombres(persona.getNombres());
        em.persist(persona);

    }

    @Transactional
    public void delete(Persona persona){
        em.remove(persona);
    }
}
