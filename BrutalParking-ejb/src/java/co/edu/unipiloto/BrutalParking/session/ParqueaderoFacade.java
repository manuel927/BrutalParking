/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.BrutalParking.session;

import co.edu.unipiloto.BrutalParking.entities.Parqueadero;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author manuel martinez
 */
@Stateless
public class ParqueaderoFacade extends AbstractFacade<Parqueadero> implements ParqueaderoFacadeLocal {

    @PersistenceContext(unitName = "BrutalParking-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ParqueaderoFacade() {
        super(Parqueadero.class);
    }
    
}
