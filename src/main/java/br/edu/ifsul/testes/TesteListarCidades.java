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
public class TesteListarCidades {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW2022-2-ModelPU"); // recebe o nome da unidade de persistencia que vem do arquivo persistence.xml  (o persistence-unit)
        EntityManager em = emf.createEntityManager();
        
        // para fazer uma consulta, preciso armazenar os valores retornado em uma variavel, nesse caso sera numa lista
        
        List<Cidade> lista = em.createQuery("from Cidade order by nome").getResultList();  // jpa faz um mapeamento objeto relacional, vou fazer uma consulta no meu objeto estado. Nao preciso fazer select com jpa, so comolocar um from da tabela (estado) e ele faz a pesquisa // Estado em maiúsculo porque ele pega o nome da Classe, e nao o nome que definimos para colocar la no banco
        
        for (Cidade c : lista){   // para cada estado achado, mostra no console o id, nome e uf dele
            System.out.println("\nID: " + c.getId() + "\nNome: " + c.getNome() + "\nUF: " + c.getEstado().getNome());
        }
        
        em.close();
        emf.close();
        
    }
    
}
