package br.unipar.jsfaula.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import br.unipar.jsfaula.domain.Usuario;

public class UsuarioDAO extends GenericDAO<Usuario> {

	public Usuario login(String usuario, String senha) {
		Criteria criteria = getSession().createCriteria(Usuario.class);
		criteria.add(Restrictions.eq("usuario", usuario));
		criteria.add(Restrictions.eq("senha", senha));
		return (Usuario) criteria.uniqueResult();
	}
}
