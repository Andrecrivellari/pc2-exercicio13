package br.com.etechoracio.training.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.springframework.stereotype.Component;

@Component(value = "cepConverter")
public class CepConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		// TODO Auto-generated method stub
		String cep = value;
		
		if(cep != null && !cep.contentEquals("")) {
			cep = value.replaceAll("[^0-9]", "");
		}
		return cep;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		// TODO Auto-generated method stub
		String cep = String.valueOf(value);
		if (cep != null && cep.length() == 8) {
			cep = cep.substring(0,6) + ".";
		}
		return cep;
	}

}
