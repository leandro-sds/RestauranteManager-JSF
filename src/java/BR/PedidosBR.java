/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BR;

import DAO.PedidosDAO;
import Entidades.Pedidos;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

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
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
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
}
