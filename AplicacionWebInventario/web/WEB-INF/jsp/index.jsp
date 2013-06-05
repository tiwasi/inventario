<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
    <head>
        <title>Proyecto Inventario</title>
    </head>
    <body align="center">
        <div class="cabecera">
                <ul id="nav" class="dropdown dropdown-linear">
                    <li><a href="./">Inicio</a></li>
                    <li class="dir">Cargo
                        <ul>
                            <li><a class="remoto" href="./cargo/frm_insertar_cargo.htm">Insertar</a></li>
                            <li><a class="remoto" href="./cargo/lista_cargos.htm">Listar</a></li>
                            <li><a class="remoto" href="./cargo/procesa_buscar_cargo.htm">buscar por id</a></li>
                        </ul>
                    </li>
                </ul>
        </div>
        <div id="panel_central" align="center">
            <div id="contenedor">

            </div>
        </div>

        <div id="loading" class="oculto">
            <img src="<c:url value="../../images/loading.gif" />" border="0" align="middle"  />
        </div>
    </body>
</html>