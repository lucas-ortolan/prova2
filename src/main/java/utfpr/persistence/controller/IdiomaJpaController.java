/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.persistence.controller;

import inscricao.persistence.entity.Idioma;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author Wilson
 */
public class IdiomaJpaController extends JpaController {

    public IdiomaJpaController() {
    }

    public List<Idioma> findAll() {
        EntityManager em = null;
        try {
            em = getEntityManager();
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Idioma> cq = cb.createQuery(Idioma.class);
            cq.from(Idioma.class);
            TypedQuery<Idioma> q = em.createQuery(cq);
            return q.getResultList();
        } finally {
            if (em != null) em.close();
        }
    }
    
    public Idioma find(String codigo){
        ArrayList<Idioma> idiomas = new ArrayList<Idioma>(this.findAll());
        for(Idioma idioma : idiomas){
            if(idioma.getCodigo().toString().equals(codigo)){
                return idioma;
            }
        }
        return null;
    }
}
