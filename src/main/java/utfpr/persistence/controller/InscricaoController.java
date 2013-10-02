/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.persistence.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import prova2.persistence.entity.Inscricao;
import prova2.persistence.entity.InscricaoMinicurso;
import prova2.persistence.entity.InscricaoMinicurso_;
import prova2.persistence.entity.Inscricao_;
import prova2.persistence.entity.Minicurso;
import prova2.persistence.entity.Minicurso_;

/**
 *
 * @author a1151207
 */
public class InscricaoController extends JpaController {

    public List<Inscricao> findAll() {
        EntityManager em = null;
        try {
            em = getEntityManager();
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Inscricao> cq = cb.createQuery(Inscricao.class);
            Root<Inscricao> c = cq.from(Inscricao.class);
            cq.select(c);
            cq.orderBy(cb.asc(c.get("nome")));
            TypedQuery<Inscricao> q = em.createQuery(cq);
            return q.getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Inscricao> findByNumber(int num) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Inscricao> cq = cb.createQuery(Inscricao.class);
            Root<Inscricao> rt = cq.from(Inscricao.class);
            cq.where(cb.equal(rt.get(Inscricao_.numero), num));
            TypedQuery<Inscricao> q = em.createQuery(cq);
            return q.getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Inscricao> findByCPF(long cpf) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Inscricao> cq = cb.createQuery(Inscricao.class);
            Root<Inscricao> rt = cq.from(Inscricao.class);
            cq.where(cb.equal(rt.get(Inscricao_.cpf), cpf));
            TypedQuery<Inscricao> q = em.createQuery(cq);
            return q.getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Minicurso> findMinicursosByInscricao(Inscricao inscricao) {
        EntityManager em = null;
        try {

            // obtem a lista de inscricao mini cursos relativas a esta inscricao
            em = getEntityManager();
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<InscricaoMinicurso> cq = cb.createQuery(InscricaoMinicurso.class);
            Root<InscricaoMinicurso> rt = cq.from(InscricaoMinicurso.class);
            cq.where(cb.equal(rt.get(InscricaoMinicurso_.inscricao), inscricao.getNumero()));
            TypedQuery<InscricaoMinicurso> q = em.createQuery(cq);

            List<Minicurso> minicursos = new ArrayList<>();
            for (Iterator<InscricaoMinicurso> it = q.getResultList().iterator(); it.hasNext();) {
                InscricaoMinicurso inscricaoMinicurso = it.next();
                CriteriaBuilder cb2 = em.getCriteriaBuilder();
                CriteriaQuery<Minicurso> cq2 = cb2.createQuery(Minicurso.class);
                Root<Minicurso> rt2 = cq2.from(Minicurso.class);
                cq2.where(cb2.equal(rt2.get(Minicurso_.codigo), inscricaoMinicurso.getMinicurso1().getCodigo()));
                TypedQuery<Minicurso> q2 = em.createQuery(cq2);
                minicursos.add(new Minicurso(q2.getFirstResult()));
            }
            return minicursos;
        } finally {
            if (em != null) {
                em.close();
            }

        }
    }

    public void salvar(Inscricao inscricao) {
        EntityManager em = null;
        try {
            em = getEntityManager();

            // Recupera o usuario do BD
            Inscricao inscricaoBD = em.find(Inscricao.class, inscricao.getNumero());
            em.getTransaction().begin();

            // Atualiza o usuario do BD com os dados da memoria
            inscricaoBD.setNome(inscricao.getNome());
            //inscricaoBD.setCpf(inscricao.getCpf());
            inscricaoBD.setCidade(inscricao.getCidade());
            inscricaoBD.setEstado(inscricao.getEstado());
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
