/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import BR.UsuariosBR;
import DAO.UsuarioDAO;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author leand
 */
@Named(value = "usuarioBean")
@RequestScoped
public class UsuarioBean implements Serializable {
    private String login;
    private String senha;
    private String tipo;
    private String nome;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String cadastrar() {        
        UsuariosBR uBR = new UsuariosBR();
        return uBR.cadastrar(this.login, this.senha, this.tipo, this.nome);
    }
    
    /**
     * Creates a new instance of UsuarioBean
     */
    public UsuarioBean() {
    }
}
