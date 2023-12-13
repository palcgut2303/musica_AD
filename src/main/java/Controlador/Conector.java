/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Album;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author manana
 */
public class Conector {
    
    private EntityManagerFactory emf;
    private EntityManager em;
    
    
    private void Sesion(){
        emf=Persistence.createEntityManagerFactory("musica");
        em = emf.createEntityManager();
    }
    
    private void CerrarSession(){
        em.close();
    }
    
    public boolean Insertar(Album a1){
       
        boolean result = false;
        
        Sesion();
        
        try {
            em.getTransaction().begin();
            em.persist(a1);
            em.getTransaction().commit();
            result = true;
            
        } catch (Exception e) {
            
        }
        CerrarSession();
        return result;
    }
    
}
