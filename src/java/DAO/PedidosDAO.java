/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Conta;
import Entidades.Pedidos;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author leand
 */
public class PedidosDAO extends GenericDAO<Pedidos> {

    private EntityManager em;

    public List<Conta> getConta() {
        em = daoHelper.getEM();
        List<Conta> contaList;
        
        Query query = em.createQuery("SELECT p.data, c.nome, c.valor, g.nome FROM Pedidos p \n"
                + "    JOIN Cardapio c ON p.idItem = c.id\n"
                + "    JOIN Garcons g ON p.idGarcon = g.id");
        contaList = query.getResultList();
        
        return contaList;
    }
}
