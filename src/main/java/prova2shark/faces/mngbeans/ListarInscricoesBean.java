package prova2shark.faces.mngbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.ListDataModel;
import prova2.persistence.entity.Inscricao;
import prova2.persistence.entity.Minicurso;
import utfpr.faces.support.PageBean;

@ManagedBean
@SessionScoped
public class ListarInscricoesBean extends PageBean {
    
    private ListDataModel<Minicurso> listaMinicursos;
    private Inscricao inscricao;

    public ListarInscricoesBean() {
       inscricao = new Inscricao();
    }
    
   public ListDataModel<Minicurso> getMinicursosDataModel() {
       return listaMinicursos;
   }
   
    public Inscricao getInscricao() {
        return inscricao;
    }

    public void setInscricao(Inscricao inscricao) {
        this.inscricao = inscricao;
    }
    
}
