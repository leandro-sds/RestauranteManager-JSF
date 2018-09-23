/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Garcons;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author leand
 */
public class GarconsDAO extends GenericDAO {
    private EntityManager em;
    
    public List<Garcons> getGarconsList() {
        em = daoHelper.getEM();
        List<Garcons> garcons;
        
        Query query = em.createNamedQuery("Garcons.findAll", Garcons.class);
        garcons = query.getResultList();
        
        return garcons;
        
    }
}
