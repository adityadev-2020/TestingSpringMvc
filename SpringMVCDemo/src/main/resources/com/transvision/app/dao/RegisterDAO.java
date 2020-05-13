package com.transvision.app.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.transvision.app.dto.RegisterDTO;
@Component
public class RegisterDAO {

	@Autowired
	private SessionFactory sf;

	public void save(RegisterDTO dto) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.save(dto);
		tx.commit();
		session.close();
	}
	
	public List<RegisterDTO> viewList() {

		Session session = sf.openSession();

		String hql = "from RegisterDTO";
		Query qry = session.createQuery(hql);

		List<RegisterDTO> list = qry.list();
		session.close();
		return list;
	}
	
	public RegisterDTO edit(int sl) {

		Session session = sf.openSession();
		
		return session.get(RegisterDTO.class, sl);
	}

	public void update(RegisterDTO dto) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		RegisterDTO temp = session.get(RegisterDTO.class, dto.getSl());
			temp.setSl(dto.getSl());
			temp.setName(dto.getName());
			temp.setAge(dto.getAge());
			temp.setStream(dto.getStream());
			session.update(temp);
		tx.commit();
		session.close();
	}
	
	public void deleteIt(int sl) {
		Session session = sf.openSession();

		String hql = "delete from RegisterDTO where sl="+sl;
		Query qry = session.createQuery(hql);
		qry.executeUpdate();
		Transaction tx = session.beginTransaction();
		tx.commit();
		session.close();
	}

	public RegisterDTO genrateReport(int sl) {
		
		Session ss=sf.openSession();
		String hql="from RegisterDTO where sl="+sl;
		Query qry=ss.createQuery(hql);
		RegisterDTO dto=(RegisterDTO) qry.uniqueResult();
		if (dto!=null) {
			return dto;
		}else {
			return null;
		}
	}
}
