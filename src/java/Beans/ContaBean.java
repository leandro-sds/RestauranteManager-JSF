/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import BR.MesasBR;
import BR.PedidosBR;
import Entidades.Conta;
import Entidades.Mesas;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author leand
 */
@Named(value = "contaBean")
@SessionScoped
public class ContaBean implements Serializable {
    private int idMesa;
    private Character formaPagamento;
    private List<Mesas> listMesas;
    private List<Conta> listContas;
    
    @PostConstruct
    private void getMesas() {
        MesasBR mesasBR = new MesasBR();
        listMesas = mesasBR.getMesasOcupadas();
    }
    
    public void atualizarContaList() {
        PedidosBR pedidosBR = new PedidosBR();
        listContas = pedidosBR.getConta(idMesa);
    }
    
    public String fecharConta() {
        PedidosBR pedidosBR = new PedidosBR();
        Date dataConta = listContas.get(0).getData();
        return pedidosBR.fecharConta(formaPagamento, dataConta, idMesa);
    }

    public List<Mesas> getListMesas() {
        return listMesas;
    }

    public void setListMesas(List<Mesas> listMesas) {
        this.listMesas = listMesas;
    }

    public int getId() {
        return idMesa;
    }

    public void setId(int id) {
        this.idMesa = id;
    }

    public List<Conta> getListContas() {
        return listContas;
    }

    public void setListContas(List<Conta> listContas) {
        this.listContas = listContas;
    }

    public Character getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(Character formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
    
}
