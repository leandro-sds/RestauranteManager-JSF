/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Cardapio;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author leand
 */
public class CardapioDAO extends GenericDAO<Cardapio> {
    private EntityManager em;
    
    public List<Cardapio> getCardapioList() {
        em = daoHelper.getEM();
        List<Cardapio> cardapioList;
        
        Query query = em.createNamedQuery("Cardapio.findAll", Cardapio.class);
        cardapioList = query.getResultList();
        
        return cardapioList;
    }
}
