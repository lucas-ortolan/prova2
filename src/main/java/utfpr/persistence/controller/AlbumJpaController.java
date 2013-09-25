/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.persistence.controller;

import flowshark.persistence.entity.Album;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author João Paulo
 */
public class AlbumJpaController extends JpaController {
    
    public List<Album> findAll() {
        EntityManager em = null;
        try {
            em = getEntityManager();
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Album> cq = cb.createQuery(Album.class);
            cq.from(Album.class);
            TypedQuery<Album> q = em.createQuery(cq);
            return q.getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void remove(Integer codigo) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            Album album = em.find(Album.class, codigo);
            em.getTransaction().begin();
            em.remove(album);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void save(Album album) {

        EntityManager em = null;
        try {
            em = getEntityManager();   
            em.getTransaction().begin();
            em.persist(album);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
}
