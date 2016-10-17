package com.ferran.domain;
import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by ferran on 17/10/16.
 */
@Entity
public class Player {
     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     private long id;
     private String name;
     private LocalDate birthdate;
     private Integer nbaskets;
    private Integer nassists;
    private Integer nrebots;
    private String pos;

    public Player(String name, LocalDate birthdate, Integer nbaskets, Integer nassists, Integer nrebots, String pos) {
        this.name = name;
        this.birthdate = birthdate;
        this.nbaskets = nbaskets;
        this.nassists = nassists;
        this.nrebots = nrebots;
        this.pos = pos;
    }

    public Player(){}

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

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public Integer getNbaskets() {
        return nbaskets;
    }

    public void setNbaskets(Integer nbaskets) {
        this.nbaskets = nbaskets;
    }

    public Integer getNassists() {
        return nassists;
    }

    public void setNassists(Integer nassists) {
        this.nassists = nassists;
    }

    public Integer getNrebots() {
        return nrebots;
    }

    public void setNrebots(Integer nrebots) {
        this.nrebots = nrebots;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthdate=" + birthdate +
                ", nbaskets=" + nbaskets +
                ", nassists=" + nassists +
                ", nrebots=" + nrebots +
                ", pos='" + pos + '\'' +
                '}';
    }
}
