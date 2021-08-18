/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jcrf.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 *
 * @author jcrfm
 */
public class AutorizadorInterceptor extends HandlerInterceptorAdapter{
    
    public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object controller)throws Exception{
        
         if(request.getSession().getAttribute("usuarioLogado") != null) {
            
            return true;
        }
        
        String uri = request.getRequestURI();
        
        if(uri.endsWith("loginForm")||uri.endsWith("efetuaLogin")||uri.contains("resources")){
        
            return true;
            
        }
        
        response.sendRedirect("loginForm");
        
        return request.getSession().getAttribute("usuarioLogado") != null;
        
    }
    
    
}
