/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventario.controladores;

import com.inventario.entidades.Cargo;
import com.inventario.servicios.ServicioCargo;
import java.util.Collections;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author lio
 */
@Controller
public class ControladorCargo {

    @Autowired
    ServicioCargo servicioCargo;

    @RequestMapping(value = "/index.htm", method = RequestMethod.GET)
    public String home() {
        return "index";
    }

    /**
     * ***************Insertar*****************************
     */
    @RequestMapping(value = "/cargo/frm_insertar_cargo.htm", method = RequestMethod.GET)
    public ModelAndView frmInsertarCargo() {
        ModelAndView res = new ModelAndView("/cargo/frm_nuevo_cargo");
        Cargo c = new Cargo();
        res.addObject("Cargo", c);
        return res;
    }

    @RequestMapping(value = "/cargo/procesa_insertar_cargo.htm", method = RequestMethod.GET)
    public ModelAndView procesarInsertarCargo(@ModelAttribute("Cargo") Cargo c) {
        if (servicioCargo.insertarCargo(c)) {
            return new ModelAndView("/cargo/exito.htm");
        }
        return new ModelAndView("/errores/error.htm");
    }

    /**
     * ************************Listar Todos************************
     */
    @RequestMapping(value = "/cargo/lista_cargos.htm", method = RequestMethod.GET)
    public ModelAndView frmListadoCargos() {
        ModelAndView res = new ModelAndView("/cargo/lista_cargos");
        res.addObject("lista", servicioCargo.listarCargos());
        res.addObject("Cargo", new Cargo());
        return res;
    }
    /*Buscar por id*/

    @RequestMapping(value = "/cargo/buscar_cargo.htm", method = RequestMethod.GET)
    public ModelAndView procesaBuscarCargo(@ModelAttribute("Cargo") Cargo cargo) {
        ModelAndView res = new ModelAndView("/cargo/buscar_cargo");
        if (cargo.getIdCargo() != null) {
            cargo = servicioCargo.buscarCargo(cargo.getIdCargo());
            res.addObject("Cargo", cargo);
        }
        return res;
    }

    @RequestMapping(value = "/cargo/procesa_buscar_cargo.htm", method = RequestMethod.GET)
    public ModelAndView procesarBuscarCargo(@RequestParam int idCargo) {
        if (servicioCargo.buscarCargo(idCargo)!=null) {
            return new ModelAndView("/cargo/exito.htm");
        }
        return new ModelAndView("/errores/error.htm");
    }
    /*Eliminar*/

    @RequestMapping(value = "/cargo/eliminar_cargo.htm", method = RequestMethod.GET)
    public String eliminarCliente(@RequestParam int idCargo) {
        return (servicioCargo.eliminarCargo(servicioCargo.buscarCargo(idCargo)) ? "exito" : "error");
    }
    /*Actualizar*/

    @RequestMapping(value = "/cargo/frm_actualizar_cargo.htm", method = RequestMethod.GET)
    public ModelAndView frmActualizarCargo(@RequestParam int codigo) {
        ModelAndView res = new ModelAndView("/cargo/frm_modificar_cargo");
        Cargo c = servicioCargo.buscarCargo(codigo);
        res.addObject("Cargo", c);
        return res;
    }

    @RequestMapping(value = "/cargo/procesa_modificar_cargo.htm", method = RequestMethod.GET)
    public ModelAndView procesarActualizarCargo(@ModelAttribute("Cargo") Cargo c) {
        if (servicioCargo.actualizarCargo(c)) {
            return new ModelAndView("/cargo/exito.htm");
        }
        return new ModelAndView("/errores/error.htm");
    }
}
