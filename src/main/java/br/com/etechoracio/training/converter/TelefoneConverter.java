package br.com.etechoracio.training.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.springframework.stereotype.Component;

@Component(value = "telefoneConverter")
public class TelefoneConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		// TODO Auto-generated method stub
		String telefone = value;
		
		if (telefone != null && !telefone.equals("")) {
			telefone = value.replaceAll("[^0-9]", "");
		}
		
		return telefone;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		// TODO Auto-generated method stub
		String telefone = String.valueOf(value);
		if (telefone != null && telefone.length() == 10) {
			telefone = "(" + telefone.substring(4) + ")" + telefone.substring(4,9) + "-" + telefone.substring(9);
		}
		return telefone;
	}

}
