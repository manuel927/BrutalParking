/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.BrutalParking.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author manuel martinez
 */
@Entity
@Table(name = "CUPO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cupo.findAll", query = "SELECT c FROM Cupo c"),
    @NamedQuery(name = "Cupo.findByNumero", query = "SELECT c FROM Cupo c WHERE c.numero = :numero"),
    @NamedQuery(name = "Cupo.findByTipodeauto", query = "SELECT c FROM Cupo c WHERE c.tipodeauto = :tipodeauto"),
    @NamedQuery(name = "Cupo.findByDisponibilidad", query = "SELECT c FROM Cupo c WHERE c.disponibilidad = :disponibilidad")})
public class Cupo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUMERO")
    private Integer numero;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "TIPODEAUTO")
    private String tipodeauto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "DISPONIBILIDAD")
    private String disponibilidad;
    @JoinColumn(name = "PARQUEADERO_PARQUEADEROID", referencedColumnName = "PARQUEADEROID")
    @ManyToOne(optional = false)
    private Parqueadero parqueaderoParqueaderoid;

    public Cupo() {
    }

    public Cupo(Integer numero) {
        this.numero = numero;
    }

    public Cupo(Integer numero, String tipodeauto, String disponibilidad) {
        this.numero = numero;
        this.tipodeauto = tipodeauto;
        this.disponibilidad = disponibilidad;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getTipodeauto() {
        return tipodeauto;
    }

    public void setTipodeauto(String tipodeauto) {
        this.tipodeauto = tipodeauto;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public Parqueadero getParqueaderoParqueaderoid() {
        return parqueaderoParqueaderoid;
    }

    public void setParqueaderoParqueaderoid(Parqueadero parqueaderoParqueaderoid) {
        this.parqueaderoParqueaderoid = parqueaderoParqueaderoid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numero != null ? numero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cupo)) {
            return false;
        }
        Cupo other = (Cupo) object;
        if ((this.numero == null && other.numero != null) || (this.numero != null && !this.numero.equals(other.numero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unipiloto.BrutalParking.entities.Cupo[ numero=" + numero + " ]";
    }
    
}
