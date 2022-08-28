/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author 20202PF.CC0011
 */
@Entity
@Table(name = "estado")
public class Estado implements Serializable{
    
    @Id
    @SequenceGenerator(name = "seq_estado", sequenceName = "seq_estado_id", allocationSize = 1) //sequenceName é o nome da sequence que sera criado no banco
    @GeneratedValue(generator = "seq_estado", strategy = GenerationType.SEQUENCE)  // gera propriamente dito o valor da sequence
    private Integer id;
    
    @NotBlank(message = "O nome deve ser informado") // definimos regras de negocio = nome nao pode ser vazio/em branco  // para string, temos que verificar se ela nao é em branco, porque nao existe string nula, ela vem em branco 
    @Length(max = 40, message = "O nome não pode ter mais que {max} caracteres") // exemplo do uso de hibernate validator, para o usuario nao inserir um nome maior que o permitido
    @Column(name = "nome", nullable = false, length = 40)   // nao permito valor nulo // tamanho é qtd de caracteres
    private String nome;
    
    @NotBlank(message = "A UF deve ser informada")
    @Length(max = 2, min = 2, message = "A UF deve ter {max} caracteres")
    @Column(name = "uf", nullable = false, length = 2) 
    private String uf;
    
   
    
    public Estado(){
        
    }
    
    // classes precisam seguir o padrao java beans: serializable, encapsulado em private, construtor e get e set
    // Sobrescrever metodo equal
    // se eu criar 2 estados (rs e sc), para comparar se sao diferentes ou iguais. Posso ter carregado duas variaveis que sao iguais, valores iguais, é interessante sobrescrever o metodo para quando for feito a comparação, ele usar o id. Pois o java normalmente verifica o endereço de memoria, que sao diferentes, entao ele nao verifica corretamente 

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Estado other = (Estado) obj;
        return Objects.equals(this.id, other.id);
    }
      
}
