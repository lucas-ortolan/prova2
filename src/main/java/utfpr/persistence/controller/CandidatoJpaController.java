/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.persistence.controller;

import inscricao.persistence.entity.Candidato;
import inscricao.persistence.entity.Idioma;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author Wilson
 */
public class CandidatoJpaController extends JpaController {

    public CandidatoJpaController() {
    }

    public List<Candidato> findAll() {
        EntityManager em = null;
        try {
            em = getEntityManager();
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Candidato> cq = cb.createQuery(Candidato.class);
            cq.from(Candidato.class);
            TypedQuery<Candidato> q = em.createQuery(cq);
            return q.getResultList();
        } finally {
            if (em != null) em.close();
        }
    }
    
    public List<Candidato> filtrar(String idioma) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            CriteriaBuilder cb = em.getCriteriaBuilder();            
            TypedQuery<Candidato> q = em.createQuery("select c from Candidato c where c.idioma = " + idioma + " order by c.nome",Candidato.class);
            return q.getResultList();
        } finally {
            if (em != null) em.close();
        }
    }
}
