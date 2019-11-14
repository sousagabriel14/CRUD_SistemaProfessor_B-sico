package br.edu.unicid.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.unicid.bean.Professor;
import br.edu.unicid.dao.ProfessorDAO;

@WebServlet("/incluir.professor")
public class ServletProfessorCadastrar extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	public ServletProfessorCadastrar() {
		super();
	} 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		Professor professor = new Professor();
	
		professor.setPis(request.getParameter("pis"));
		professor.setNomeProfessor(request.getParameter("nome"));
		

		try {
			ProfessorDAO professorDAO = new ProfessorDAO();
			professorDAO.salvar(professor); 	
		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("mensagem", "Cadastrou Professor " + request.getParameter("nome")); 
		RequestDispatcher rd = request.getRequestDispatcher("incluir.jsp"); 
		rd.forward(request, response); 
	}
	
}
