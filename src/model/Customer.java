package model;

import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
  
/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation
 * @author mas
 *
 */
@Entity
@Table(name="CUSTOMER")
@ManagedBean(name="customer")
public class Customer {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
      
    private String name;
      
    private String city;
  
    public int getId() {
        return id;
    }
  
    public void setId(int id) {
        this.id = id;
    }
  
    public String getName() {
        return name;
    }
  
    public void setName(String name) {
        this.name = name;
    }
  
    public String getCity() {
        return city;
    }
  
    public void setCity(String city) {
        this.city = city;
    }
      
    @Override
    public String toString(){
        return "id="+id+", name="+name+", city="+city;
    }
}