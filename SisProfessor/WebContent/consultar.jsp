<%@ taglib prefix="resp" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consultar professor</title>
</head>
	<body>
	   <form action=" ${pageContext.request.contextPath}/consultar.professor" method="get">
		   <table style="width:50%" border = "1px" align ="center">
			   	<tr>
			     <td colspan="2" align ="center" ><h3>Buscar Professor</h3></td>   
			  	</tr>
			   	<tr>
			   	 <td  align ="right">Nome Professor:</td>
			     <td>
			      <input type="text" name="nomeProfessor">
			      <input type="submit" name="Buscar" value="Buscar">
			     </td>
			   	</tr>
			</table> 
		    <table style="width:50%" border = "1px" align ="center">
		   	    <tr>
				 <th>PIS</th>
				 <th>NOME</th>
			    </tr>
		   	    <resp:forEach items="${professor}" var="professor">
			   	 <tr>   	   		   	   					 
				  <td>${professor.pis}</td>
				  <td>${professor.nomeProfessor}</td>				    				    	
				 </tr>
		   	    </resp:forEach>
			</table>
			<center>
			 <br>
			 <a href="index.jsp">Clique aqui para voltar a página principal.</a>
			 <br>
			</center>
		</form>	
	</body>
</html>