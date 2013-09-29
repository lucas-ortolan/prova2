/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package flowshark.persistence.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "avaliacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Avaliacao.findAll", query = "SELECT a FROM Avaliacao a"),
    @NamedQuery(name = "Avaliacao.findByCodigo", query = "SELECT a FROM Avaliacao a WHERE a.codigo = :codigo"),
    @NamedQuery(name = "Avaliacao.findByEstrela", query = "SELECT a FROM Avaliacao a WHERE a.estrela = :estrela")})
public class Avaliacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo")
    private Integer codigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estrela")
    private int estrela;
    @JoinColumn(name = "usuario", referencedColumnName = "email")
    @ManyToOne(optional = false)
    private Usuario usuario;
    @JoinColumn(name = "faixa", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Faixa faixa;

    public Avaliacao() {
    }

    public Avaliacao(Integer codigo) {
        this.codigo = codigo;
    }

    public Avaliacao(Integer codigo, int estrela) {
        this.codigo = codigo;
        this.estrela = estrela;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public int getEstrela() {
        return estrela;
    }

    public void setEstrela(int estrela) {
        this.estrela = estrela;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Faixa getFaixa() {
        return faixa;
    }

    public void setFaixa(Faixa faixa) {
        this.faixa = faixa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Avaliacao)) {
            return false;
        }
        Avaliacao other = (Avaliacao) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "flowshark.persistence.entity.Avaliacao[ codigo=" + codigo + " ]";
    }
    
}
