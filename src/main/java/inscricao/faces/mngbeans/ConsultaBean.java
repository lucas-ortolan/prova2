package inscricao.faces.mngbeans;

import inscricao.persistence.entity.Candidato;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.ListDataModel;
import utfpr.faces.support.PageBean;
import utfpr.persistence.controller.CandidatoJpaController;

@ManagedBean
@RequestScoped
public class ConsultaBean extends PageBean {
        
   private ListDataModel<Candidato> listaCandidatosDataModel;
   private String codigoIdioma;

    public ConsultaBean() {
       CandidatoJpaController ctl = new CandidatoJpaController();
       listaCandidatosDataModel = new ListDataModel<Candidato>(ctl.findAll());
    }      
    
   public ListDataModel<Candidato> getCandidatoDataModel() {
       return listaCandidatosDataModel;
   }
   
   public String filtrarIdiomaAction() {
       CandidatoJpaController ctl = new CandidatoJpaController();
       listaCandidatosDataModel = new ListDataModel<Candidato>(ctl.filtrar(codigoIdioma));
       return "consulta";
   }

    public String getCodigoIdioma() {
        return codigoIdioma;
    }

    public void setCodigoIdioma(String codigoIdioma) {
        this.codigoIdioma = codigoIdioma;
    } 
    
//    public String excluirAction() {
//        Candidato candidato = listaCandidatosDataModel.getRowData();
//        candidatosBean.getListaCandidatos().remove(candidato);
//        listaCandidatosDataModel = new ListDataModel<>(((CandidatosBean)getBean("candidatosBean")).getListaCandidatos());
//        return null;
//    }
//    
//    public String editarAction() {
//        InscricaoBean inscricaoBean = (InscricaoBean) getBean("inscricaoBean");
//        inscricaoBean.setCandidato(listaCandidatosDataModel.getRowData());
//        return inscricaoBean.alterar();
//    }
}