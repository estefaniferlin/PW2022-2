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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author 20202PF.CC0011
 */
@Entity
@Table (name = "cidade")
public class Cidade implements Serializable{
    
    @Id
    @SequenceGenerator(name = "seq_cidade", sequenceName = "seq_cidade_id", allocationSize = 1) // valor padrao é 50, entao colocamos 1
    @GeneratedValue(generator = "seq_cidade", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotBlank(message = "O nome deve ser informado")
    @Length(max = 40, message = "O nome não pode ter mais de {max} caracteres")
    @Column(name = "nome", nullable = false, length = 40)
    private String nome;
    
    @NotNull(message = "O estado deve ser informado")
    @ManyToOne
    @JoinColumn(name = "estado", referencedColumnName = "id", nullable = false)
    private Estado estado;
    
    public Cidade(){
        
    }

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

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.id);
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
        final Cidade other = (Cidade) obj;
        return Objects.equals(this.id, other.id);
    }
    
}
