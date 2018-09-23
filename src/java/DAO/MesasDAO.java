/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Conta;
import Entidades.Mesas;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author leand
 */
public class MesasDAO extends GenericDAO<Mesas> {
    private EntityManager em;
    
    public List<Mesas> getMesasList() {
        em = daoHelper.getEM();
        List<Mesas> mesas;
        
        Query query = em.createNamedQuery("Mesas.findFreeTables", Mesas.class);
        mesas = query.getResultList();
        
        return mesas;
    }
    
    public List<Mesas> getMesasOcupadas() {
        em = daoHelper.getEM();
        List<Mesas> mesas;
        
        Query query = em.createNamedQuery("Mesas.findOccupiedTables", Mesas.class);
        mesas = query.getResultList();
        
        return mesas;
    }
    
    public int updateStatus(Mesas mesa) {
        em = daoHelper.getEM();
        
        if(mesa != null) {
            Query query = em.createQuery("UPDATE Mesas m SET m.status = 1 WHERE m.id = :id");
            query.setParameter("id", mesa.getId());
            
            em.getTransaction().begin();
            int affected_rows = query.executeUpdate();
            em.getTransaction().commit();
            
            return affected_rows;
        } else {
            return 0;
        }
    }
    
    public List<Conta> getConta() {
        em = daoHelper.getEM();
        List<Conta> contaList;
        
        Query query = em.createQuery("SELECT p.data data, c.nome nomePedido, c.valor, g.nome nomeGarcom FROM Pedidos p \n"
                + "    JOIN Cardapio c ON p.idItem = c.id\n"
                + "    JOIN Garcons g ON p.idGarcon = g.id", Conta.class);
        contaList = query.getResultList();
        
        return contaList;
    }
}
