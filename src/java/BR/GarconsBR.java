/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BR;

import DAO.GarconsDAO;
import Entidades.Garcons;
import java.util.List;

/**
 *
 * @author leand
 */
public class GarconsBR {
    private GarconsDAO garconsDAO;
    
    public String cadGarcom(String nome) {
        String url;
        
        if (nome.isEmpty()) {
            return url = "erro";
        } else {
            Garcons garcom = new Garcons(nome);
            garconsDAO = new GarconsDAO();
            garconsDAO.salvar(garcom);
            return "dashboard";
        }
    }
    
    public List<Garcons> getGarconsList() {
        garconsDAO = new GarconsDAO();
        return garconsDAO.getGarconsList();
    }
}
