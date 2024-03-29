/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prova2.faces.convert;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Wilson
 */
@FacesConverter("CPFConverter")
public class CPFConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        return string == null || string.trim().isEmpty() ? null : Long.valueOf(string.replace("-", ""));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        Long cpf = (Long) o;
        return String.format("%09d-%02d", cpf / 100, cpf % 100);
    }
    
}
