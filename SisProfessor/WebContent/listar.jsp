<%@      taglib prefix="resp" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listar professor</title>
</head>
<body>
   <form action=" ${pageContext.request.contextPath}/listar.professor" method="get">
	   <table style="width:50%" border = "1px" align ="center">
		   	<tr>
		    <td colspan="2"  align ="center" ><h3>Listar Professor</h3></td>   
		  	</tr>
		   	<tr>
		   	<td  align ="right">PIS.:</td>
		    <td><input type="text" name="pis"> <input type="submit" name="buscar" value="Buscar"></td>
		   	</tr>
		   	<tr>
		    <td colspan="2"  align ="left" ><b><resp:out value="${mensagem}" /><br>
		    </b>
		    <resp:out value="${mensagem0}" /><br>
		    <resp:out value="${mensagem1}" /><br>
		    <resp:out value="${mensagem2}" /><br>
		    <resp:out value="${mensagem3}" /><br>
		    <resp:out value="${mensagem4}" /><br>
		    <resp:out value="${mensagem5}" /><br>		    
		    </td>
		    </tr> 
		</table>
		<center><br><a href="index.jsp" >Clique aqui para voltar a página principal.</a><br></center>
	</form>	
</body>
</html>