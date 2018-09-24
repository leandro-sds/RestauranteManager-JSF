/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.math.BigDecimal;
import java.util.Date;
/**
 *
 * @author leand
 */
public class Conta {
    private Date data;
    private String dataString;
    private String nomeGarcom;
    private String nomePedido;
    private BigDecimal valor;

    public Conta(Date data, String nomePedido, BigDecimal valor, String nomeGarcom) {
        this.data = data;
        this.nomeGarcom = nomeGarcom;
        this.nomePedido = nomePedido;
        this.valor = valor;
        this.dataString = "";
    }
    
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
    public String getDataString() {
        return dataString;
    }

    public void setDataString(String dataString) {
        this.dataString = dataString;
    }

    public String getNomeGarcom() {
        return nomeGarcom;
    }

    public void setNomeGarcom(String nomeGarcom) {
        this.nomeGarcom = nomeGarcom;
    }

    public String getNomePedido() {
        return nomePedido;
    }

    public void setNomePedido(String nomePedido) {
        this.nomePedido = nomePedido;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
