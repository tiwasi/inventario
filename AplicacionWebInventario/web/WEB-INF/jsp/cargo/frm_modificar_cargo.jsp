<%-- 
    Document   : frm_modificar_cargo
    Created on : 02/06/2013, 08:22:29 PM
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
        <title>Modificar</title>
    </head>
    <body align="center">
        <table border="0" width="100%">
            <tr>
                <td>
                </td>
            </tr>
            <tr>
                <td>
                    <div align="center">
                        <h1>Modificar Cargo</h1><br />
                        <form:form method="GET" action="procesa_modificar_cargo.htm" commandName="Cargo" id="frm" >
                            <fieldset>
                                <legend class="texte_legende">Codigo</legend>
                                <div id="div_contact">
                                    <div class="texte"></div>
                                    <div id="champ_contact"><input class="champ" type="text" name="idCargo" id="name" placeholder="Codigo Cargo" required value="${Cargo.idCargo}" onkeypress="return isNumberKey(event);"/></div>
                                </div>
                                <div id="div_contact">
                                    <div class="texte">Nombre :</div>
                                    <div id="champ_contact"><form:input path="nombreCargo"/></div>
                                </div>
                                <div id="div_contact">
                                    <div class="texte">Descripcion :</div>
                                    <div id="champ_contact"><form:input path="descripcionCargo" /></div>
                                </div>
                                <div id="div_contact">
                                    <div class="texte">estadoCargo :</div>
                                    <div id="champ_contact"><form:input path="estadoCargo"/></div>
                                </div>

                                <p>&nbsp;</p>
                            </fieldset>
                            <div id="div_contact_button">
                                <input type="submit" value="Aceptar"/>
                            </div>
                        </form:form>
                    </div>
                </td>
            </tr>
        </table>
    </body>
</html>
<script language="javascript">
function isNumberKey(evt) {
 var charCode = (evt.which) ? evt.which : event.keyCode
 if (charCode > 31 && (charCode < 48 || charCode > 57))
    return false;
 return true;
}
</script>
<script language="javascript">
    $("#frm").submit(function() {
        var r = confirm("Esta seguro de registrar el cargo?");
        if (r == true)
        {
            $.blockUI({
                centerY: 0,
                message: "<h1>Espere un momento!!</h1>",
                css: {top: '10px', left: '', right: '10px'}
            });
            var frmr = $(this).serialize();
            $.get('procesa_insetar_cargo.htm', frmr, function(response) {
                $.unblockUI();
                alert(response.mensaje);
                cargarVistaEnContenedor("lista_cargo.htm");
            }, 'json');
        }
        else {
            var frm = $(this).serialize();
        }
        return false;
    });
</script>