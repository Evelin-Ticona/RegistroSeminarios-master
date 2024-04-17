
<%@page import="javax.websocket.Session"%>
<%@page import="com.emergentes.registroseminarios.Persona"%>
<%@page import="java.util.ArrayList"%>
<%
	if(session.getAttribute("listaPer")== null){
	ArrayList<Persona> lisaux= new ArrayList<Persona>();
	session.setAttribute("listaPer",lisaux);
	}
	ArrayList<Persona> lista = (ArrayList<Persona>) session.getAttribute("listaPer");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>listado de registros</h1>
<a href="MainServlet?op=nuevo">Nuevo Registro</a>
<table border="1">
	<tr>
		<td>Id</td>
		<th>Fecha</th>
		<th>Nombres</th>
		<th>Apellidos</th>
		<th>Turno</th>
		<th>Seminarios</th>
		
	</tr>
	<%
	if(lista != null){
		for(Persona item : lista){

	%>

	<tr>
		<td><%=item.getId() %></td>
		<td><%=item.getNombres() %></td>
		<td><%=item.getApellidos() %></td>
		<td><%=item.getTurno() %></td>
		<td><%=item.getSeminarios() %></td>
		
		<td>
			<a href="MainServlet?op=editar&id=<%=item.getId()%>">Editar</a>
		</td>
		<td>
			<a href="MainServlet?op=eliminar&id=<%=item.getId() %>" onclick="return(confirm('Esta seguro de eliminar....'))">Eliminar</a>
		</td>
		<td></td>
	</tr>
	<%
		
		}
	}
	%>
        </table>
    </body>
</html>