/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BR;

import DAO.MesasDAO;
import Entidades.Mesas;
import java.util.List;

/**
 *
 * @author leand
 */
public class MesasBR {
    private MesasDAO mesasDAO;
    
    public List<Mesas> getMesasList() {
        mesasDAO = new MesasDAO();
        return mesasDAO.getMesasList();
    }
    
    public List<Mesas> getMesasOcupadas() {
        mesasDAO = new MesasDAO();
        return mesasDAO.getMesasOcupadas();
    }
    
    public int updateStatus(Mesas mesa) {
        mesasDAO = new MesasDAO();
        return mesasDAO.updateStatus(mesa);
    }
    
    public void fecharConta() {
        mesasDAO = new MesasDAO();
        mesasDAO.getConta();
    }
}
