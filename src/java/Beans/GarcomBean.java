/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import BR.GarconsBR;
import Entidades.Garcons;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author leand
 */

@Named(value = "garconBean")
@RequestScoped
public class GarcomBean {
    private String nome;
    private List<Garcons> garcons;
    
    @PostConstruct
    private void getGarconsList() {
        GarconsBR garconsBR = new GarconsBR();
        garcons = garconsBR.getGarconsList();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Garcons> getGarcons() {
        return garcons;
    }

    public void setGarcons(List<Garcons> garcons) {
        this.garcons = garcons;
    }
    
    public String cadGarcom() {
        GarconsBR garcombr = new GarconsBR();
        return garcombr.cadGarcom(nome);
    }
}
