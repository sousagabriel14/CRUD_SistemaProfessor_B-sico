package br.edu.unicid.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import br.edu.unicid.bean.Professor;
import br.edu.unicid.util.ConnectionFactory;

public class ProfessorDAO {

	private Connection conn;
	private PreparedStatement ps;
	
	public ProfessorDAO() throws Exception {
		// chama a classe ConnectionFactory e estabelece uma conexão
		try {
			this.conn = ConnectionFactory.getConnection();
		} catch (Exception e) {
			throw new Exception("erro: \n" + e.getMessage());
		}
	}
	
	// método de salvar Professor

		public void salvar(Professor professor) throws Exception {
			if (professor == null)
				throw new Exception("O valor passado nao pode ser nulo");
			try {
				String SQL = "INSERT INTO tbProfessor (pis, "
						+ "nomeProfessor) "
						+ "values (?, ?)";

				ps = this.conn.prepareStatement(SQL);
				ps.setString(1, professor.getPis());
				ps.setString(2, professor.getNomeProfessor());
				ps.executeUpdate();
			} catch (SQLException sqle) {
				throw new Exception("Erro ao inserir dados " + sqle);
			} finally {
				ConnectionFactory.closeConnection(conn, ps);
			}

		}
		
		
		//método Excluir professor
		public String excluirProfessor (String pis) throws Exception {
			try {	

				String SQL = "DELETE FROM tbprofessor WHERE `pis` = ?";

				ps = this.conn.prepareStatement(SQL);
				ps.setString(1, pis);			
				ps.executeUpdate();

			} catch (SQLException sqle) {
				throw new Exception("Erro ao deletar dados " + sqle);
			} finally {
				ConnectionFactory.closeConnection(conn, ps);
			}
			return "Excluiu professor: " + pis;
		}
		
		
		//método Listar Professor
		public List<Professor> listar() throws Exception {
			List<Professor> listaProfessores = new ArrayList<Professor>();
			try {
				String SQL = "Select * from tbprofessor";

				ps = this.conn.prepareStatement(SQL);
				ResultSet dados = ps.executeQuery();
				while(dados.next()){
					Professor professor = new Professor();
					professor.setPis(dados.getString("pis"));
					professor.setNomeProfessor(dados.getString("nomeProfessor"));
					listaProfessores.add(professor);
				}

			} catch (SQLException sqle) {
				throw new Exception("Erro ao listar dados " + sqle);
			} finally {
				ConnectionFactory.closeConnection(conn, ps);
			}
			return listaProfessores;
		}
		
		//
		public Professor listarProfessor(String pis)throws Exception{
			Professor professor = new Professor();
			
			try {
				String SQL = "Select * from tbprofessor Where pis = ?";
				ps = this.conn.prepareStatement(SQL);
				ps.setString(1, pis);
				ResultSet dados = ps.executeQuery();
				while(dados.next()){	
					professor.setPis(dados.getString("pis"));
					professor.setNomeProfessor(dados.getString("nomeProfessor"));
				}

			} catch (SQLException sqle) {
				throw new Exception("Erro ao listar dados do aluno " + sqle);
			} finally {
				ConnectionFactory.closeConnection(conn, ps);
			}
			return professor;
		}
		

		public List<Professor> listarProfessorLike(String nomeProfessor)throws Exception{
			List<Professor> listaProfessores = new ArrayList<Professor>();
			
			try {
				String SQL = "Select * from tbprofessor Where nomeProfessor LIKE '" + nomeProfessor + "%' ORDER BY nomeProfessor";
				
				ps = this.conn.prepareStatement(SQL);
				
				ResultSet dados = ps.executeQuery();
				
				while(dados.next()){	
					Professor professor = new Professor();
					professor.setPis(dados.getString("pis"));
					professor.setNomeProfessor(dados.getString("nomeProfessor"));
					
					//System.out.print(professor.getPis());
					//System.out.print(professor.getNomeProfessor());
					
					listaProfessores.add(professor);
				}

			} catch (SQLException sqle) {
				throw new Exception("Erro ao listar dados do professor like " + sqle);
			} finally {
				ConnectionFactory.closeConnection(conn, ps);
			}
			
			return listaProfessores;
		}
		
		
			//Alterar / atualizar Professor
		 public void atualizar(Professor professor, String pis) throws Exception {
			if (professor == null)
				throw new Exception("O valor passado nao pode ser nulo");
			try {

				String SQL = "UPDATE tbprofessor SET "
						+ "`pis` = ?, "
						+ "`nomeProfessor` = ? " 
						+ "Where `pis` = ? ";

				ps = this.conn.prepareStatement(SQL);
				ps.setString(1, professor.getPis());
				ps.setString(2, professor.getNomeProfessor());
				ps.setString(3, pis);
				ps.executeUpdate();

			} catch (SQLException sqle) {
				throw new Exception("Erro ao atualizar dados " + sqle);
			} finally {
				ConnectionFactory.closeConnection(conn, ps);
			}
		}
		

		
	
}
