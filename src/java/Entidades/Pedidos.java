/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leand
 */
@Entity
@Table(name = "pedidos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pedidos.findAll", query = "SELECT p FROM Pedidos p")
    , @NamedQuery(name = "Pedidos.findById", query = "SELECT p FROM Pedidos p WHERE p.id = :id")
    , @NamedQuery(name = "Pedidos.findByIdItem", query = "SELECT p FROM Pedidos p WHERE p.idItem = :idItem")
    , @NamedQuery(name = "Pedidos.findByIdGarcon", query = "SELECT p FROM Pedidos p WHERE p.idGarcon = :idGarcon")
    , @NamedQuery(name = "Pedidos.findByIdMesa", query = "SELECT p FROM Pedidos p WHERE p.idMesa = :idMesa")
    , @NamedQuery(name = "Pedidos.findByData", query = "SELECT p FROM Pedidos p WHERE p.data = :data")
    , @NamedQuery(name = "Pedidos.findByPagamento", query = "SELECT p FROM Pedidos p WHERE p.pagamento = :pagamento")
    , @NamedQuery(name = "Pedidos.findByStatus", query = "SELECT p FROM Pedidos p WHERE p.status = :status")})
public class Pedidos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idItem")
    private int idItem;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idGarcon")
    private int idGarcon;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idMesa")
    private int idMesa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(name = "Pagamento")
    private Character pagamento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Status")
    private Character status;

    public Pedidos() {
    }

    public Pedidos(Integer id) {
        this.id = id;
    }

    public Pedidos(Integer id, int idItem, int idGarcon, int idMesa, Date data, Character status) {
        this.id = id;
        this.idItem = idItem;
        this.idGarcon = idGarcon;
        this.idMesa = idMesa;
        this.data = data;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public int getIdGarcon() {
        return idGarcon;
    }

    public void setIdGarcon(int idGarcon) {
        this.idGarcon = idGarcon;
    }

    public int getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Character getPagamento() {
        return pagamento;
    }

    public void setPagamento(Character pagamento) {
        this.pagamento = pagamento;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
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
        if (!(object instanceof Pedidos)) {
            return false;
        }
        Pedidos other = (Pedidos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Pedidos[ id=" + id + " ]";
    }
    
}
