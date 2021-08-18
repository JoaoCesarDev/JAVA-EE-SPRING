/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jcrf.teste;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author jcrfm
 */
@Controller
public class OlaMundoController {
    
    @RequestMapping("/OlaMundoSpring")
    public  String execute(){
        System.out.println("Excutando a lógica com SpringMVC");
        return "ok";
    }
    
    
}
