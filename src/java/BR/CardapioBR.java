/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BR;

import DAO.CardapioDAO;
import Entidades.Cardapio;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author leand
 */
public class CardapioBR {
    private CardapioDAO cardapioDAO;
    
    public List<Cardapio> getCardapioList() {
        cardapioDAO = new CardapioDAO();
        return cardapioDAO.getCardapioList();
    }
    
    public String cadastrarPrato(String nome, BigDecimal valor) {
        if(nome.isEmpty() || valor == null) {
            return "erro";
        } else {
            Cardapio cardapio = new Cardapio(nome, valor);
            cardapioDAO = new CardapioDAO();
            cardapioDAO.salvar(cardapio);
            
            return "dashboard";            
        }
    }
}
