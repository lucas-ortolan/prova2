/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prova2shark.faces.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import utfpr.util.DigitoVerificadorCPF;

/**
 *
 * @author Wilson
 */
@FacesValidator("CPFValidator")
public class CPFValidator implements Validator {

    @Override
    public void validate(FacesContext fc, UIComponent uic, Object o) throws ValidatorException {
        String cpf = String.format("%011d", (Long) o);
        if (!cpf.matches("\\d{11}")) {        
            throw new ValidatorException(new FacesMessage("CPF \'" + cpf + "\' em formato incorreto."));
        } else {
            DigitoVerificadorCPF dvcpf = new DigitoVerificadorCPF(cpf.substring(0, 9));
            int dv = Integer.parseInt(cpf.substring(9, 11));
            if (!dvcpf.isValido(dv)) {
                throw new ValidatorException(new FacesMessage("CPF \'" + cpf + "\' inválido"));
            }
        }
    }
    
}
