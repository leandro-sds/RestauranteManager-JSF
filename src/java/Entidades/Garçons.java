/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leand
 */
@Entity
@Table(name = "gar\u00e7ons")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gar\u00e7ons.findAll", query = "SELECT g FROM Gar\u00e7ons g")
    , @NamedQuery(name = "Gar\u00e7ons.findById", query = "SELECT g FROM Gar\u00e7ons g WHERE g.id = :id")
    , @NamedQuery(name = "Gar\u00e7ons.findByNome", query = "SELECT g FROM Gar\u00e7ons g WHERE g.nome = :nome")})
public class Garçons implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Nome")
    private String nome;

    public Garçons() {
    }

    public Garçons(Integer id) {
        this.id = id;
    }

    public Garçons(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Garçons)) {
            return false;
        }
        Garçons other = (Garçons) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Gar\u00e7ons[ id=" + id + " ]";
    }
    
}
