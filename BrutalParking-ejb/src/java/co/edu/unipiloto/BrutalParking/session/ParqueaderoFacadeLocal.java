/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.BrutalParking.session;

import co.edu.unipiloto.BrutalParking.entities.Parqueadero;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author manuel martinez
 */
@Local
public interface ParqueaderoFacadeLocal {

    void create(Parqueadero parqueadero);

    void edit(Parqueadero parqueadero);

    void remove(Parqueadero parqueadero);

    Parqueadero find(Object id);

    List<Parqueadero> findAll();

    List<Parqueadero> findRange(int[] range);

    int count();
    
}
