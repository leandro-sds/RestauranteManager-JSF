/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

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
}
