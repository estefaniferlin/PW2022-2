/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Estado;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author 20202PF.CC0011
 */
public class TesteRemoverEstado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW2022-2-ModelPU"); // recebe o nome da unidade de persistencia que vem do arquivo persistence.xml  (o persistence-unit)
        EntityManager em = emf.createEntityManager();
        
        //Estado e = new Estado();
        //e.setId(1);
        
        Estado e = em.find(Estado.class, 3);
        e.setNome("Santa Catarina");
        e.setUf("SC");
         
        em.getTransaction().begin();
        em.remove(e);
        em.getTransaction().commit();
        em.close();
        emf.close();

        // criar em build and clean e depois dar um run file aqui para testar
    
    }
    
}
