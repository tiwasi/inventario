/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventario.controladores;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author lio
 */
@Controller
public class ControladorLogin extends HibernateDaoSupport{

    @Autowired
    public ControladorLogin(SessionFactory sf) {
        super.setSessionFactory(sf);
    }
    @RequestMapping(value = "frm_login.htm")
    public ModelAndView procesaLogin(){
        ModelAndView res = new ModelAndView("frm_login.htm");
        return res;
    }
    @RequestMapping(value = "procesa_login.htm")
    public void validar(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
       String user = req.getParameter("login");
		String pass = req.getParameter("pass");
		if ("edu4java".equals(user) && "eli4java".equals(pass)) {
			response(resp, "login ok");
		} else {
			response(resp, "invalid login");
		}
    }
    
    private void response(HttpServletResponse resp, String msg)
			throws IOException {
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<t1>" + msg + "</t1>");
		out.println("</body>");
		out.println("</html>");
	}
    
}
