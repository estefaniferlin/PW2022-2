/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.modelo.Estado;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author 20202PF.CC0011
 */
public class TestePersistirEstado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW2022-2-ModelPU"); // recebe o nome da unidade de persistencia que vem do arquivo persistence.xml  (o persistence-unit)
        EntityManager em = emf.createEntityManager();
        
        Estado e = new Estado();
        e.setId(1);     
        e.setNome("Rio Grande do Sul");
        e.setUf("RS");
        
        em.getTransaction().begin();
        em.persist(e);  // persiste o estado criado
        em.getTransaction().commit();
        em.close();
        emf.close();
 
    }
    
}
