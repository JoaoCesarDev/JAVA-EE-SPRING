/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jcrf.controller;



import br.com.jcrf.dao.GenericHibernateDao;
import br.com.jcrf.entity.Usuario;
import br.com.jcrf.entity.bCrypt;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



/**
 *
 * @author jcrfm
 */
@Controller
@EnableTransactionManagement(proxyTargetClass = true)
public class loginController {
  
    private final GenericHibernateDao<Usuario> hibernatedao;
    
    @Autowired
    public loginController(GenericHibernateDao hibernatedao) {
        this.hibernatedao = hibernatedao;
    }
  
  @RequestMapping(value="/", method = RequestMethod.GET)
  public String paginaLogin(){
     
    return "usuario/paginaLogin";
    
  }
  
  @RequestMapping("loginForm")
  public String loginForm() {
      
    return "usuario/paginaLogin";
    
  }
  @Transactional  
  @RequestMapping("efetuaLogin")
  public String efetuaLogin(Usuario usuario, HttpSession session,Model model) {
                  
        if(hibernatedao.existe(usuario.getLogin(),usuario.getSenha(),usuario)) {
          
          session.setAttribute("usuarioLogado", usuario);
          
          usuario = (Usuario) hibernatedao.perfil(usuario, usuario.getLogin());
          
          model.addAttribute("perfilUsuario",usuario);
          
          return "usuario/index";
          
      }
      
      return "usuario/paginaLogin";
  }
   
    @RequestMapping("logout")
    public String logout(HttpSession session) {
        
      session.invalidate();
      
      return "redirect:loginForm";
  } 
    
}
