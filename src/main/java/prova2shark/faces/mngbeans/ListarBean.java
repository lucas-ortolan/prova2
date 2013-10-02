package prova2shark.faces.mngbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.ListDataModel;
import prova2.persistence.entity.Inscricao;
import utfpr.faces.support.PageBean;
import utfpr.persistence.controller.InscricaoController;

@ManagedBean
@SessionScoped
public class ListarBean extends PageBean {
    
    private ListDataModel<Inscricao> listaInscricoes;
    private boolean edicao = false;
    private Inscricao inscricao;

    public ListarBean() {
       inscricao = new Inscricao();
       InscricaoController ctl = new InscricaoController();
       listaInscricoes = new ListDataModel<>(ctl.findAll());
    }
    
   public ListDataModel<Inscricao> getInscricoesDataModel() {
       return listaInscricoes;
   }
   
   public void editarInscricao(Inscricao inscricao) {
       edicao = true;
       this.inscricao = inscricao;       
   }
   
   public String listarMinicursos(Inscricao inscricao) {
       ListarInscricoesBean listaInscricoes = (ListarInscricoesBean) getBean("listarInscricoesBean");
       listaInscricoes.setInscricao(inscricao);
       return "listarInscricoes";
   }
   
   public void salvarInscricao() {
       InscricaoController ctl = new InscricaoController();
       ctl.salvar(inscricao);
       edicao = false;
   }

    public boolean isEdicao() {
        return edicao;
    }

    public Inscricao getInscricao() {
        return inscricao;
    }

    public void setInscricao(Inscricao inscricao) {
        this.inscricao = inscricao;
    }
    
}
