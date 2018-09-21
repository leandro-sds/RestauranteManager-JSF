/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import DAO.DAOHelper;
import Entidades.Usuarios;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author leand
 */
@Named(value = "loginBean")
@RequestScoped
public class LoginBean {

    private String login;
    private String senha;

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

    public String autenticaLogin() {
        String url = "";
        DAOHelper daoHelper = new DAOHelper();

        EntityManager em = daoHelper.getEM();

        Query query = em.createQuery("SELECT u FROM Usuarios u WHERE u.login = :login AND u.senha = :senha");
        query.setParameter("login", login);
        query.setParameter("senha", senha);

        Usuarios usuario = (Usuarios) query.getSingleResult();

        if (usuario.getLogin().equalsIgnoreCase(login) && usuario.getSenha().equalsIgnoreCase(senha)) {
            url = "dashboard.xhtml";
            Object x = new Object();
            SessionUtil.setParam("UsuarioLogado", x);
        } else {
            url = "index.xhtml";
        }
        
        return url;
    }
}
