/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import BR.CardapioBR;
import BR.GarconsBR;
import BR.MesasBR;
import BR.PedidosBR;
import Entidades.Cardapio;
import Entidades.Garcons;
import Entidades.Mesas;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author leand
 */
@Named(value = "pedidosBean")
@RequestScoped
public class PedidosBean {
    private int idItem;
    private int idGarcom;
    private int idMesa;
    private List<Mesas> mesasList;
    private List<Garcons> garconsList;
    private List<Cardapio> cardapioList;
    
    @PostConstruct
    private void carregarListas() {
        GarconsBR garconsBR = new GarconsBR();
        MesasBR mesasBR = new MesasBR();
        CardapioBR cardapioBR = new CardapioBR();
        
        this.garconsList = garconsBR.getGarconsList();
        this.mesasList = mesasBR.getMesasOcupadas();
        this.cardapioList = cardapioBR.getCardapioList();
    }
    
    public String cadastrarPedido() {
        PedidosBR pedidosBR = new PedidosBR();
        return pedidosBR.cadastrarPedido(idGarcom, idItem, idMesa);
    }
    
    //Getter e Setter

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public int getIdGarcom() {
        return idGarcom;
    }

    public void setIdGarcom(int idGarcon) {
        this.idGarcom = idGarcon;
    }

    public int getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }

    public List<Mesas> getMesasList() {
        return mesasList;
    }

    public void setMesasList(List<Mesas> mesasList) {
        this.mesasList = mesasList;
    }

    public List<Garcons> getGarconsList() {
        return garconsList;
    }

    public void setGarconsList(List<Garcons> garconsList) {
        this.garconsList = garconsList;
    }

    public List<Cardapio> getCardapioList() {
        return cardapioList;
    }

    public void setCardapioList(List<Cardapio> cardapioList) {
        this.cardapioList = cardapioList;
    }
}
