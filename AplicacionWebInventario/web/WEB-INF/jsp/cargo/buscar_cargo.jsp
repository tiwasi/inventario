<%-- 
    Document   : buscar_cliente
    Created on : 02/03/2013, 03:40:34 AM
    Author     : root
--%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
    <head>
        <title>Buscar Cargo</title>
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
                    <div>
                        <h1>Buscar Cliente</h1><br />
                        <form:form method="GET" action="buscar_cargo.htm" commandName="Cargo" id="frm">
                            <fieldset>
                                <legend class="texte_legende">Codigo</legend>
                                <div id="div_contact">
                                    <div class="texte"></div>
                                    <div id="champ_contact"><form:input path="idCargo"/></div>
                                </div>
                                <p>&nbsp;</p>
                            </fieldset>
                            <div id="div_contact_button">
                                <input type="submit" value="Buscar">
                            </div>
                        </form:form>
                    </div>
                </td>
            </tr>
        </table>
        <table border=1 align="center" width="80%">
            <tr>
                <th>Codigo</th>
                <th>Nombre</th>
                <th>Descripcion</th>
                <th>Estado</th>
            </tr>
            <tr>
                <td>${Cargo.idCargo}</td>
                <td>${Cargo.nombreCargo}</td>
                <td>${Cargo.descripcionCargo}</td>
                <td>${Cargo.estadoCargo}</td>
            </tr>
    </body>
</html>