package com.transvision.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.transvision.app.dao.LoginDAO;
import com.transvision.app.dao.RegisterDAO;
import com.transvision.app.dto.LoginDTO;
import com.transvision.app.dto.RegisterDTO;
@Component
public class Service {

	@Autowired
	private LoginDAO ldao;
	public LoginDTO toSend(LoginDTO dto) {
		return ldao.check(dto);
	}
	
	@Autowired
	private RegisterDAO rdao;

	public void toSave(RegisterDTO dto) {
		
		rdao.save(dto);
	}
	
	public List<RegisterDTO> viewList() {

		return rdao.viewList();
	}
	
	public RegisterDTO edit(int sl) {

		return rdao.edit(sl);
	}

	public void toUpdate(RegisterDTO dto) {
		rdao.update(dto);
	}
	
	public void delete(int sl) {

		rdao.deleteIt(sl);
	}

	public RegisterDTO report(int sl) {
		
		return rdao.genrateReport(sl);
	}
}
