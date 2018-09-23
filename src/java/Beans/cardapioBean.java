/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import BR.CardapioBR;
import Entidades.Cardapio;
import java.math.BigDecimal;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author leand
 */
@Named(value = "cardapioBean")
@RequestScoped
public class cardapioBean {
    private String nome;
    private BigDecimal valor;
    private List<Cardapio> cardapioList;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public List<Cardapio> getCardapioList() {
        CardapioBR cardapioBR = new CardapioBR();
        cardapioList = cardapioBR.getCardapioList();
        
        return cardapioList;
    }

    public void setCardapioList(List<Cardapio> cardapioList) {
        this.cardapioList = cardapioList;
    }
    
    public String cadastrarPrato() {
        CardapioBR cardapioBR = new CardapioBR();
        return cardapioBR.cadastrarPrato(nome, valor);
    }
}
