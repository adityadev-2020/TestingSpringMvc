package com.transvision.app.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.transvision.app.dto.LoginDTO;
@Component
public class LoginDAO {

	@Autowired
	private SessionFactory sf;
	public LoginDTO check(LoginDTO dto) {

		Session session = sf.openSession();
		String hql = "from LoginDTO where id='" + dto.getId() + "' and pass='" + dto.getPass() + "'";
		Query qry = session.createQuery(hql);

		dto = (LoginDTO) qry.uniqueResult();
		session.close();
		return dto;
	}
}
