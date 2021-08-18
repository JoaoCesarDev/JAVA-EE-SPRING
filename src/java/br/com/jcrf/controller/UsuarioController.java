/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jcrf.controller;



import br.com.jcrf.dao.GenericHibernateDao;

import br.com.jcrf.entity.Usuario;
import br.com.jcrf.entity.bCrypt;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

    
/**
 *
 * @author jcrfm
 */

@Controller
@EnableTransactionManagement(proxyTargetClass = true)

public class UsuarioController {

    private final GenericHibernateDao<Usuario> hibernatedao;
    
    @Autowired
    public UsuarioController(GenericHibernateDao<Usuario> hibernatedao) {
        this.hibernatedao = hibernatedao;
    }
   
     
    @RequestMapping("formulario")
    public String formulario(Model model,Usuario usuario) {
        
        model.addAttribute("Usuario",usuario);
       
        return "usuario/formulario";
    }
    
    @RequestMapping("home")
    public String home() {
           
        return "usuario/index";
    }
   
    @InitBinder("Usuario")
    public void customizeBinding (WebDataBinder binder) {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        dateFormatter.setLenient(false);
        binder.registerCustomEditor(Calendar.class, "dataCriacao",
                                    new CustomDateEditor(dateFormatter, true));
    }
   @Transactional
    @PostMapping("adicionarUsuario")
    public String adicionaUsuario(@Valid @ModelAttribute("Usuario")Usuario usuario, BindingResult result,Model model){
      
        if(result.hasErrors()){
            return "usuario/formulario";
        }else{
        usuario.setSenha(bCrypt.hashPassword(usuario.getSenha()));
        hibernatedao.create(usuario);
        }
        model.addAttribute("Usuario", usuario);       
        return "usuario/UsuarioAdicionado";
    }
    
   @Transactional
    @RequestMapping("listaUsuarios")
    public String lista(Model model,Usuario usuario){
        
       List<Usuario> usuarios = hibernatedao.findall(usuario);
            
        model.addAttribute("usuarios",usuarios);
        
        return "usuario/lista";
        
    }
    @Transactional
    @RequestMapping("removeUsuario")
    public String remove(Usuario usuario) {
        
        hibernatedao.delete(usuario);
        
        return "redirect:listaUsuarios";
    }
    
    @Transactional
    @RequestMapping("mostraUsuario")
    public String mostra(Long id,Usuario usuario, Model model) {
       
       usuario = (Usuario) hibernatedao.procura(usuario, id);
        
       model.addAttribute("usuario", usuario);
        
       return "usuario/exibeUsuario";
    }
        
    @Transactional
    @PostMapping("alteraUsuario")
    public String altera(@Valid @ModelAttribute("usuario")Usuario usuario,BindingResult result) {
         
        if(result.hasErrors()){
            return "redirect:listaUsuarios";
        }else{
     
       hibernatedao.update(usuario);
            
        }
        return "redirect:listaUsuarios";
        
    }
}

