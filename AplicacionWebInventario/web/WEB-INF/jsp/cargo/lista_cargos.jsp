<%-- 
    Document   : listado_cargos
    Created on : 02/06/2013, 12:11:40 PM
    Author     : lio
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de Cargos</title>
    </head>
    <body align="center">
        <table border="0" width="100%">
            <tr>
                <td>
                </td>
            </tr>
            <!-- / END -->
            <tr>
                <td>
                    <h1>Listado Cargos</h1>
                    <table border="1" align="center" width="100px%">
                        <tr>
                            <th>Codigo</th>
                            <th>NOmbre</th>
                            <th>Descripcion</th>
                            <th>Estado</th>
                        </tr>
                        <c:forEach items="${lista}" var="t" >
                            <tr>
                                <td>${t.idCargo}</td>
                                <td>${t.nombreCargo}</td>
                                <td>${t.descripcionCargo}</td>
                                <td>${t.estadoCargo}</td>
                                <td align="center">
                                    <a class="remoto" href="frm_actualizar_cargo.htm?codigo=${t.idCargo}">Modificar</a>-
                                    <a class="remoto" onclick="return confirm('Realmente desea eliminar el registro?')" href="eliminar_cargo.htm?codigo=${t.idCargo}">Eliminar</a>
                                </td>
                            </tr>
                            
                        </c:forEach>
                    </table>
                </td>
            </tr>
        </table>
    </body>
</html>
