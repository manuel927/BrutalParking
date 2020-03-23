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
@Table(name = "RESERVA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reserva.findAll", query = "SELECT r FROM Reserva r"),
    @NamedQuery(name = "Reserva.findByNumeroreserva", query = "SELECT r FROM Reserva r WHERE r.numeroreserva = :numeroreserva"),
    @NamedQuery(name = "Reserva.findByUsuario", query = "SELECT r FROM Reserva r WHERE r.usuario = :usuario"),
    @NamedQuery(name = "Reserva.findByParqueadero", query = "SELECT r FROM Reserva r WHERE r.parqueadero = :parqueadero"),
    @NamedQuery(name = "Reserva.findByHora", query = "SELECT r FROM Reserva r WHERE r.hora = :hora")})
public class Reserva implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUMERORESERVA")
    private Integer numeroreserva;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "USUARIO")
    private String usuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PARQUEADERO")
    private String parqueadero;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "HORA")
    private String hora;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reservaNumeroreserva")
    private Collection<Parqueadero> parqueaderoCollection;
    @JoinColumn(name = "PARQUEADERO_PARQUEADEROID", referencedColumnName = "PARQUEADEROID")
    @ManyToOne(optional = false)
    private Parqueadero parqueaderoParqueaderoid;
    @JoinColumn(name = "TIQUETE_TIQUETEID", referencedColumnName = "TIQUETEID")
    @ManyToOne(optional = false)
    private Tiquete tiqueteTiqueteid;
    @JoinColumn(name = "USUARIO_CEDULA", referencedColumnName = "CEDULA")
    @ManyToOne(optional = false)
    private Usuario usuarioCedula;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reservaNumeroreserva")
    private Collection<Tiquete> tiqueteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reservaNumeroreserva")
    private Collection<Usuario> usuarioCollection;

    public Reserva() {
    }

    public Reserva(Integer numeroreserva) {
        this.numeroreserva = numeroreserva;
    }

    public Reserva(Integer numeroreserva, String usuario, String parqueadero, String hora) {
        this.numeroreserva = numeroreserva;
        this.usuario = usuario;
        this.parqueadero = parqueadero;
        this.hora = hora;
    }

    public Integer getNumeroreserva() {
        return numeroreserva;
    }

    public void setNumeroreserva(Integer numeroreserva) {
        this.numeroreserva = numeroreserva;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getParqueadero() {
        return parqueadero;
    }

    public void setParqueadero(String parqueadero) {
        this.parqueadero = parqueadero;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    @XmlTransient
    public Collection<Parqueadero> getParqueaderoCollection() {
        return parqueaderoCollection;
    }

    public void setParqueaderoCollection(Collection<Parqueadero> parqueaderoCollection) {
        this.parqueaderoCollection = parqueaderoCollection;
    }

    public Parqueadero getParqueaderoParqueaderoid() {
        return parqueaderoParqueaderoid;
    }

    public void setParqueaderoParqueaderoid(Parqueadero parqueaderoParqueaderoid) {
        this.parqueaderoParqueaderoid = parqueaderoParqueaderoid;
    }

    public Tiquete getTiqueteTiqueteid() {
        return tiqueteTiqueteid;
    }

    public void setTiqueteTiqueteid(Tiquete tiqueteTiqueteid) {
        this.tiqueteTiqueteid = tiqueteTiqueteid;
    }

    public Usuario getUsuarioCedula() {
        return usuarioCedula;
    }

    public void setUsuarioCedula(Usuario usuarioCedula) {
        this.usuarioCedula = usuarioCedula;
    }

    @XmlTransient
    public Collection<Tiquete> getTiqueteCollection() {
        return tiqueteCollection;
    }

    public void setTiqueteCollection(Collection<Tiquete> tiqueteCollection) {
        this.tiqueteCollection = tiqueteCollection;
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroreserva != null ? numeroreserva.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reserva)) {
            return false;
        }
        Reserva other = (Reserva) object;
        if ((this.numeroreserva == null && other.numeroreserva != null) || (this.numeroreserva != null && !this.numeroreserva.equals(other.numeroreserva))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unipiloto.BrutalParking.entities.Reserva[ numeroreserva=" + numeroreserva + " ]";
    }
    
}
