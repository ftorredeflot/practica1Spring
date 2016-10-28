package com.ferran.domain;
import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by ferran on 20/10/16.
 */
@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(unique=true)
    private String name;
    private String city;
   // private LocalDate fundate;

    public Team(String name, String city/*, LocalDate fundate*/) {
        this.name = name;
        this.city = city;
        //this.fundate = fundate;
    }

    public Team(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

   /* public LocalDate getFundate() {
        return fundate;
    }

    public void setFundate(LocalDate fundate) {
        this.fundate = fundate;
    }*/

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
