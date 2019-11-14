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

@WebServlet("/atualizar.professor")
public class ServletProfessorAtualizar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public ServletProfessorAtualizar() {
		super();
	} 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		Professor professorBusca = new Professor();
		Professor professorSalvo = new Professor();

		String botaoClicado = request.getParameter("enviar");

		String pis = request.getParameter("pis");

		if(botaoClicado.equals("buscar")) {
			try {				
				ProfessorDAO professorDAO = new ProfessorDAO();
				professorBusca = professorDAO.listarProfessor(pis);	
			} catch (Exception e) {
				e.printStackTrace();
			}

			request.setAttribute("mensagem0", professorBusca.getPis());
			request.setAttribute("mensagem1", professorBusca.getNomeProfessor());

			RequestDispatcher rd = request.getRequestDispatcher("alterar.jsp"); 
			rd.forward(request, response); 

		}else if (botaoClicado.equals("salvar")){

			try {
				professorSalvo.setPis(request.getParameter("pis"));
				professorSalvo.setNomeProfessor(request.getParameter("nomeProfessor"));

				ProfessorDAO professorDAO = new ProfessorDAO();
				professorDAO.atualizar(professorSalvo, request.getParameter("pisEscondido")); 	
			} catch (Exception e) {
				e.printStackTrace();
			}
			request.setAttribute("mensagem", "Atualizou o Professor "+ request.getParameter("nomeProfessor")); 
			RequestDispatcher rd = request.getRequestDispatcher("alterar.jsp"); 
			rd.forward(request, response); 
		}
	}
}