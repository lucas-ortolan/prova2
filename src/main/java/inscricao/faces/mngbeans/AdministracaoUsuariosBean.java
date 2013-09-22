package inscricao.faces.mngbeans;

import inscricao.persistence.entity.Usuario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.ListDataModel;
import utfpr.faces.support.PageBean;
import utfpr.persistence.controller.UsuarioJpaController;

@ManagedBean
@RequestScoped
public class AdministracaoUsuariosBean extends PageBean {
        
   private ListDataModel<Usuario> listaUsuarios;

    public AdministracaoUsuariosBean() {
       UsuarioJpaController ctl = new UsuarioJpaController();
       listaUsuarios = new ListDataModel<Usuario>(ctl.findAll());
    }      
    
   public ListDataModel<Usuario> getUsuariosDataModel() {
       return listaUsuarios;
   }
}