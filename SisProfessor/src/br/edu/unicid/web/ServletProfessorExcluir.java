package br.edu.unicid.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.unicid.dao.ProfessorDAO;

@WebServlet("/excluir.professor")
public class ServletProfessorExcluir extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	public ServletProfessorExcluir() {
		super();
	} 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	
		try {
			String pis = request.getParameter("pis");
			ProfessorDAO professorDAO = new ProfessorDAO();
			String retorno = professorDAO.excluirProfessor(pis);
			
			request.setAttribute("mensagem", retorno);
			
			RequestDispatcher rd = request.getRequestDispatcher("excluir.jsp");
			
			rd.forward(request, response); 
		} catch (Exception e) {
			e.printStackTrace();
		}			 	
	}
	

}
