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
@Table(name = "PARQUEADERO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Parqueadero.findAll", query = "SELECT p FROM Parqueadero p"),
    @NamedQuery(name = "Parqueadero.findByParqueaderoid", query = "SELECT p FROM Parqueadero p WHERE p.parqueaderoid = :parqueaderoid"),
    @NamedQuery(name = "Parqueadero.findByDireccion", query = "SELECT p FROM Parqueadero p WHERE p.direccion = :direccion"),
    @NamedQuery(name = "Parqueadero.findByCupos", query = "SELECT p FROM Parqueadero p WHERE p.cupos = :cupos"),
    @NamedQuery(name = "Parqueadero.findByNombre", query = "SELECT p FROM Parqueadero p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Parqueadero.findByTarifa", query = "SELECT p FROM Parqueadero p WHERE p.tarifa = :tarifa")})
public class Parqueadero implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PARQUEADEROID")
    private Integer parqueaderoid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "DIRECCION")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CUPOS")
    private int cupos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TARIFA")
    private int tarifa;
    @JoinColumn(name = "RESERVA_NUMERORESERVA", referencedColumnName = "NUMERORESERVA")
    @ManyToOne(optional = false)
    private Reserva reservaNumeroreserva;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parqueaderoParqueaderoid")
    private Collection<Reserva> reservaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parqueaderoParqueaderoid")
    private Collection<Cupo> cupoCollection;

    public Parqueadero() {
    }

    public Parqueadero(Integer parqueaderoid) {
        this.parqueaderoid = parqueaderoid;
    }

    public Parqueadero(Integer parqueaderoid, String direccion, int cupos, String nombre, int tarifa) {
        this.parqueaderoid = parqueaderoid;
        this.direccion = direccion;
        this.cupos = cupos;
        this.nombre = nombre;
        this.tarifa = tarifa;
    }

    public Integer getParqueaderoid() {
        return parqueaderoid;
    }

    public void setParqueaderoid(Integer parqueaderoid) {
        this.parqueaderoid = parqueaderoid;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCupos() {
        return cupos;
    }

    public void setCupos(int cupos) {
        this.cupos = cupos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTarifa() {
        return tarifa;
    }

    public void setTarifa(int tarifa) {
        this.tarifa = tarifa;
    }

    public Reserva getReservaNumeroreserva() {
        return reservaNumeroreserva;
    }

    public void setReservaNumeroreserva(Reserva reservaNumeroreserva) {
        this.reservaNumeroreserva = reservaNumeroreserva;
    }

    @XmlTransient
    public Collection<Reserva> getReservaCollection() {
        return reservaCollection;
    }

    public void setReservaCollection(Collection<Reserva> reservaCollection) {
        this.reservaCollection = reservaCollection;
    }

    @XmlTransient
    public Collection<Cupo> getCupoCollection() {
        return cupoCollection;
    }

    public void setCupoCollection(Collection<Cupo> cupoCollection) {
        this.cupoCollection = cupoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (parqueaderoid != null ? parqueaderoid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Parqueadero)) {
            return false;
        }
        Parqueadero other = (Parqueadero) object;
        if ((this.parqueaderoid == null && other.parqueaderoid != null) || (this.parqueaderoid != null && !this.parqueaderoid.equals(other.parqueaderoid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unipiloto.BrutalParking.entities.Parqueadero[ parqueaderoid=" + parqueaderoid + " ]";
    }
    
}
