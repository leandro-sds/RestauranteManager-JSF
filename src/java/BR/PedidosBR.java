/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BR;

import DAO.MesasDAO;
import DAO.PedidosDAO;
import Entidades.Conta;
import Entidades.Pedidos;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

/**
 *
 * @author leand
 */
public class PedidosBR {

    private PedidosDAO pedidosDAO;

    public String cadastrarPedido(int idGarcom, int idItem, int idMesa) {
        if (idGarcom == 0 || idItem == 0 || idMesa == 0) {
            return "erro";
        } else {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date();

            try {
                Date dataPedido = dateFormat.parse(dateFormat.format(date));
                pedidosDAO = new PedidosDAO();
                Pedidos pedido = new Pedidos(idItem, idGarcom, idMesa, dataPedido);
                pedidosDAO.salvar(pedido);
            } catch (Exception e) {
            }
            
            return "dashboard";
        }
    }
    
    public List<Conta> getConta(int id) {
        pedidosDAO = new PedidosDAO();
        return pedidosDAO.getConta(id);
    }
    
    public String fecharConta(Character formaPagamento,Date dataConta, int idMesa) {
        pedidosDAO = new PedidosDAO();
        int result = pedidosDAO.fecharConta(formaPagamento, dataConta, idMesa);
        
        if (result > 0) {
            return "dashboard";
        } else {
            return "erro";
        }
    }
}
