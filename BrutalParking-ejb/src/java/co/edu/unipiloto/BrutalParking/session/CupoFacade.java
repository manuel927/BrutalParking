/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.BrutalParking.session;

import co.edu.unipiloto.BrutalParking.entities.Cupo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author manuel martinez
 */
@Stateless
public class CupoFacade extends AbstractFacade<Cupo> implements CupoFacadeLocal {

    @PersistenceContext(unitName = "BrutalParking-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CupoFacade() {
        super(Cupo.class);
    }
    
}
