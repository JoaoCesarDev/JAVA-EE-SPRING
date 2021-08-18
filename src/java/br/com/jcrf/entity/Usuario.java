/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jcrf.entity;


import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;

import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author jcrfm
 */
@Entity
@Table(name="usuario")
@SequenceGenerator(name="seq",sequenceName="seq_user",allocationSize = 1, initialValue = 1)
public class Usuario implements Serializable{
   
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="login")
    @NotEmpty
    private String login;
    @Column(name="senha")
    @NotEmpty
    private String senha;
    @Column(name="dataCriacao")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar dataCriacao;
    @Column(name="perfil")
    @NotEmpty
    private String perfil;
    /**
     * @param id
     * @param login
     * @param senha
     * @param dataCriacao
     * @param perfil
     */
    public Usuario(){}
    
    public Usuario(Long id,String login,String senha,Calendar dataCriacao,String perfil){
        super();
        this.id = id;
        this.login = login;
        this.perfil = perfil;
        this.senha = senha;
        this.dataCriacao = dataCriacao;        
    }
    
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        
        this.senha = senha;
    }

    /**
     * @return the dataCriacao
     */
    public Calendar getDataCriacao() {
        return dataCriacao;
    }

    /**
     * @param dataCriacao the dataCriacao to set
     */
    public void setDataCriacao(Calendar dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    /**
     * @return the perfil
     */
    public String getPerfil() {
        return perfil;
    }

    /**
     * @param perfil the perfil to set
     */
    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }
    
}
