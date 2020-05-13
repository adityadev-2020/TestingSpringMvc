package com.transvision.app.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.itextpdf.text.pdf.PdfWriter;
import com.transvision.app.dto.LoginDTO;
import com.transvision.app.dto.RegisterDTO;
import com.transvision.app.service.Service;

@Component
@RequestMapping("/")
public class Controller {

	@Autowired
	private Service s;
	
	@RequestMapping(value= "/lc")
	public ModelAndView login(@ModelAttribute LoginDTO dto, HttpServletRequest req) {
		try {
			dto = s.toSend(dto);
			HttpSession session = req.getSession();
			session.setAttribute("user", dto.getId());
			return new ModelAndView("/link.jsp");
		} catch (Exception e) {
			return new ModelAndView("/Login.jsp", "invalid", "invalid user and password pls try again");
		}
	}
	
	@RequestMapping(value = "/rc")
	public ModelAndView register(@ModelAttribute RegisterDTO dto,HttpServletRequest req) {
		System.out.println("inside controller");
		System.out.println(dto.getAge());
		if(Integer.parseInt(dto.getAge())>20 && Integer.parseInt(dto.getAge())<40)
		{	
			s.toSave(dto);
			return new ModelAndView("/View.jsp","success","Registration Successfull");
		}	
		else
		{
			HttpSession session = req.getSession();
			session.setAttribute("age", dto.getAge());
			return new ModelAndView("/Registration.jsp","invalid","invalid age");
		}
	}
	
	@RequestMapping(value = "/view")
	public ModelAndView viewList() {
		List<RegisterDTO> list = s.viewList();

		System.out.println(list);
		return new ModelAndView("Display.jsp", "list", list);
	}
	
	@RequestMapping("/edit")
	public ModelAndView edit(@ModelAttribute RegisterDTO dto){
		dto = s.edit(dto.getSl());
		
		return new ModelAndView("edit.jsp", "edit", dto);
	}
	@RequestMapping("/update")
	public ModelAndView update(@ModelAttribute RegisterDTO dto,HttpServletRequest req){
		System.out.println(dto.getAge());
		if(Integer.parseInt(dto.getAge())>20 && Integer.parseInt(dto.getAge())<40)
		{	
			s.toUpdate(dto);
			return new ModelAndView("/update.jsp");
		}	
		else
		{
			return new ModelAndView("/Registration.jsp","invalid","invalid age");
		}
	}
	
	@RequestMapping("/delete")
	public String deleteData(@ModelAttribute RegisterDTO dto) {
		System.out.println("id = " + dto.getSl());
		s.delete(dto.getSl());
		return "redirect:/view";
	}
	
	String pdfFile;
	@RequestMapping(value="/report")
	public ModelAndView report(@ModelAttribute RegisterDTO dto) throws IOException, DocumentException{
		
		dto=s.report(dto.getSl());
		if (dto!=null) {
			pdfFile = String.valueOf(dto.getSl());
			System.out.println(dto.getSl());
			Document document = new Document();

				FileOutputStream file = new FileOutputStream("D://Report//"+pdfFile+".pdf");

				PdfWriter.getInstance(document, file);
				document.open();
				document.add(new Paragraph("Name: "+dto.getName()));
				document.add(new Paragraph("Name: "+dto.getAge()));
				document.add(new Paragraph("Name: "+dto.getStream()));
				document.close();
				file.close();
			return new ModelAndView("/success.jsp");
		}else {
			return new ModelAndView("/User.jsp","invalid","invalid id no pls try again");
		}
		
	}
	
	@RequestMapping("/DownloadFile")
	public void download(HttpServletRequest request, HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		String filename = ""+pdfFile+".pdf";
		String filepath = "D:\\Report\\";
		response.setContentType("APPLICATION/OCTET-STREAM");
		response.setHeader("Content-Disposition", "attachment; filename=\""
				+ filename + "\"");
 
		// use inline if you want to view the content in browser, helpful for
		// pdf file
		// response.setHeader("Content-Disposition","inline; filename=\"" +
		// filename + "\"");
		FileInputStream fileInputStream = new FileInputStream(filepath
				+ filename);
 
		int i;
		while ((i = fileInputStream.read()) != -1) {
			out.write(i);
		}
		fileInputStream.close();
		out.close();
	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response){
		HttpSession hs=request.getSession(false);
		hs.invalidate();
		return "/index.jsp";
	}
}
