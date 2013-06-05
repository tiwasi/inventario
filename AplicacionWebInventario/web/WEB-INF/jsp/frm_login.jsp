<%-- 
    Document   : frm_login
    Created on : 03/06/2013, 03:20:07 PM
    Author     : lio
--%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login de usuario</h1>
        <table>
            <form:form action="procesa_login.htm" method="POST" commandName="login" id="form">            
            <tr>
                <td>
                    <form:label path="login" id="login">User:</form:label>
                </td>
                <td>
                <form:input path="pass"/>
                </td>
                <td><input type="submit" value="Aceptar"/></td>
            </tr>
            </form:form>
        </table>
        
    </body>
</html>
