/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Conta;
import Entidades.Pedidos;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author leand
 */
public class PedidosDAO extends GenericDAO<Pedidos> {

    private EntityManager em;

    public List<Conta> getConta(int id) {
        em = daoHelper.getEM();
        List<Conta> contaList;

        Query query = em.createQuery("SELECT new Entidades.Conta(p.data, c.nome, c.valor, g.nome) FROM Pedidos p \n"
                + "    JOIN Cardapio c ON p.idItem = c.id\n"
                + "    JOIN Garcons g ON p.idGarcon = g.id\n"
                + "WHERE p.idMesa = :id AND p.status = '0'");
        query.setParameter("id", id);
        contaList = query.getResultList();

        for (Conta conta : contaList) {
            DateFormat dateFormat = new SimpleDateFormat("dd/MM");
            Date data = conta.getData();
            conta.setDataString(dateFormat.format(data));
        }

        return contaList;
    }

    public int fecharConta(Character formaPagamento, Date dataConta, int idMesa) {
        em = daoHelper.getEM();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
        try {
            Date dataPedido = dateFormat.parse(dateFormat.format(dataConta));
            if (formaPagamento != null || dataConta != null || idMesa != 0) {
                Query query = em.createQuery("UPDATE Pedidos p SET p.status = '1', p.pagamento = :formaPagamento WHERE p.idMesa = :idMesa AND p.data = :data");
                query.setParameter("formaPagamento", formaPagamento);
                query.setParameter("idMesa", idMesa);
                query.setParameter("data", dataPedido);

                em.getTransaction().begin();
                int affected_rows = query.executeUpdate();
                em.getTransaction().commit();

                return affected_rows;
            } else {
                return 0;
            }
        } catch (Exception e) {
        }
        return 0;
    }
}
