/*
 */
package model.entities;

import java.io.Serializable;
import java.util.Objects;

/*Implements Serializables é para que os objetos sejam transformados 
 *em sequência de bytes. Na linguagem Java isso tem que ser feito para 
 *que os objetos sejam gravados em arquivo e trafeguem em rede*/
public class Department implements Serializable {
    
    //A linha abaixo foi exigida no curso com o Eclipse, mas não com o NetBeans-12
    //private static final long serialVersionUID = 1L;

    //Atributos
    private Integer id;
    private String name;
//==============================================================================

    //Construtores vazio
    public Department() {

    }

    //Construtor com argumentos
    public Department(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
//==============================================================================

    //Métodos Getter/Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
//==============================================================================

    //Métodos hasCode/equals
    /*Para que os objetos possam ser comparados pelo conteúdo e 
     *não pela referência de ponteiros.*/
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.id);
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
        final Department other = (Department) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
//==============================================================================

    //Método toString
    @Override
    public String toString() {
        return "Department{" + "id=" + id + ", name=" + name + '}';
    }
}
