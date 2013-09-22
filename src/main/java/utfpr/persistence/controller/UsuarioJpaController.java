package utfpr.persistence.controller;

import inscricao.persistence.entity.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

public class UsuarioJpaController extends JpaController {

    public UsuarioJpaController() {
    }

    public List<Usuario> findAll() {
        EntityManager em = null;
        try {
            em = getEntityManager();
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Usuario> cq = cb.createQuery(Usuario.class);
            cq.from(Usuario.class);
            TypedQuery<Usuario> q = em.createQuery(cq);
            return q.getResultList();
        } finally {
            if (em != null) em.close();
        }
    }  
}
