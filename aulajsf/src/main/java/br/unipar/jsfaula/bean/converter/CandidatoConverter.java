package br.unipar.jsfaula.bean.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.unipar.jsfaula.dao.GenericDAO;
import br.unipar.jsfaula.domain.Candidato;

@FacesConverter(forClass = Candidato.class, value = "candidatoConverter")
public class CandidatoConverter implements Converter {
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if (value != null && !value.isEmpty()) {
            GenericDAO<Candidato> dao = new GenericDAO<>();
        	return dao.buscarPorCodigo(Candidato.class, Long.parseLong(value));
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
        if (value instanceof Candidato) {
        	Candidato entity= (Candidato) value;
            if (entity != null && entity instanceof Candidato && entity.getCodigo() != null) {
                uiComponent.getAttributes().put( entity.getCodigo().toString(), entity);
                return entity.getCodigo().toString();
            }
        }
        return "";
    }
}
