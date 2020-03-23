/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.BrutalParking.session;

import co.edu.unipiloto.BrutalParking.entities.Cupo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author manuel martinez
 */
@Local
public interface CupoFacadeLocal {

    void create(Cupo cupo);

    void edit(Cupo cupo);

    void remove(Cupo cupo);

    Cupo find(Object id);

    List<Cupo> findAll();

    List<Cupo> findRange(int[] range);

    int count();
    
}
