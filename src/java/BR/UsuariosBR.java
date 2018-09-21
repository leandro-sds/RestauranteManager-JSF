/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BR;

import DAO.UsuarioDAO;
import Entidades.Usuarios;

/**
 *
 * @author leand
 */
public class UsuariosBR {

    private Usuarios usuario = null;
    UsuarioDAO daouser = null;

    public String cadastrar(String login, String senha, String tipo, String nome) {
        String url;
        usuario = new Usuarios();
        daouser = new UsuarioDAO();
        if (login.isEmpty() || senha.isEmpty()) {
            url = "/index";
        } else {
            usuario.setLogin(login);
            usuario.setSenha(senha);
            usuario.setTipo(tipo);
            usuario.setNome(nome);
            usuario = daouser.salvar(usuario);
            url = "/dashboard";
        }
        return url;
    }
}
