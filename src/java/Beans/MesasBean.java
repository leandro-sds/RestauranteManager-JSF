/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import BR.MesasBR;
import Entidades.Mesas;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author leand
 */
@Named(value = "mesasBean")
@RequestScoped
public class MesasBean {

    private int status;
    private List<Mesas> listmesas;
    private MesasBR mesasBR = new MesasBR();

    public MesasBean() {
        this.listmesas = mesasBR.getMesasList();
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<Mesas> getListmesas() {
        return listmesas;
    }

    public void setListmesas(List<Mesas> listmesas) {
        this.listmesas = listmesas;
    }

    public String updateMesaStatus(Mesas mesa) {
        mesasBR.updateStatus(mesa);
        return "dashboard";
    }

    public void fecharConta() {
        MesasBR mesasBR = new MesasBR();
        mesasBR.fecharConta();
    }
}
