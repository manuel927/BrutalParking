/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.BrutalParking.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author manuel martinez
 */
@Entity
@Table(name = "TIQUETE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tiquete.findAll", query = "SELECT t FROM Tiquete t"),
    @NamedQuery(name = "Tiquete.findByTiqueteid", query = "SELECT t FROM Tiquete t WHERE t.tiqueteid = :tiqueteid"),
    @NamedQuery(name = "Tiquete.findByEntrada", query = "SELECT t FROM Tiquete t WHERE t.entrada = :entrada"),
    @NamedQuery(name = "Tiquete.findBySalida", query = "SELECT t FROM Tiquete t WHERE t.salida = :salida"),
    @NamedQuery(name = "Tiquete.findByFecha", query = "SELECT t FROM Tiquete t WHERE t.fecha = :fecha"),
    @NamedQuery(name = "Tiquete.findByTarifa", query = "SELECT t FROM Tiquete t WHERE t.tarifa = :tarifa")})
public class Tiquete implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIQUETEID")
    private Integer tiqueteid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ENTRADA")
    private String entrada;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "SALIDA")
    private String salida;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "FECHA")
    private String fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TARIFA")
    private int tarifa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tiqueteTiqueteid")
    private Collection<Reserva> reservaCollection;
    @JoinColumn(name = "RESERVA_NUMERORESERVA", referencedColumnName = "NUMERORESERVA")
    @ManyToOne(optional = false)
    private Reserva reservaNumeroreserva;

    public Tiquete() {
    }

    public Tiquete(Integer tiqueteid) {
        this.tiqueteid = tiqueteid;
    }

    public Tiquete(Integer tiqueteid, String entrada, String salida, String fecha, int tarifa) {
        this.tiqueteid = tiqueteid;
        this.entrada = entrada;
        this.salida = salida;
        this.fecha = fecha;
        this.tarifa = tarifa;
    }

    public Integer getTiqueteid() {
        return tiqueteid;
    }

    public void setTiqueteid(Integer tiqueteid) {
        this.tiqueteid = tiqueteid;
    }

    public String getEntrada() {
        return entrada;
    }

    public void setEntrada(String entrada) {
        this.entrada = entrada;
    }

    public String getSalida() {
        return salida;
    }

    public void setSalida(String salida) {
        this.salida = salida;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getTarifa() {
        return tarifa;
    }

    public void setTarifa(int tarifa) {
        this.tarifa = tarifa;
    }

    @XmlTransient
    public Collection<Reserva> getReservaCollection() {
        return reservaCollection;
    }

    public void setReservaCollection(Collection<Reserva> reservaCollection) {
        this.reservaCollection = reservaCollection;
    }

    public Reserva getReservaNumeroreserva() {
        return reservaNumeroreserva;
    }

    public void setReservaNumeroreserva(Reserva reservaNumeroreserva) {
        this.reservaNumeroreserva = reservaNumeroreserva;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tiqueteid != null ? tiqueteid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tiquete)) {
            return false;
        }
        Tiquete other = (Tiquete) object;
        if ((this.tiqueteid == null && other.tiqueteid != null) || (this.tiqueteid != null && !this.tiqueteid.equals(other.tiqueteid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unipiloto.BrutalParking.entities.Tiquete[ tiqueteid=" + tiqueteid + " ]";
    }
    
}
