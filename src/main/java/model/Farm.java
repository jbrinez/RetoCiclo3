package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table (name = "farm")
public class Farm  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFarm;
    private String name;
    private String address;
    private Integer extension;

    @ManyToOne
    @JoinColumn(name = "idCategory")
    @JsonIgnoreProperties("farms")
    private Farm farm;

    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "farm")
    @JsonIgnoreProperties({"farm","client"})
    private List<Reservation> messages;


    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "farm")
    @JsonIgnoreProperties({"farm","client"})
    private List<Reservation> reservations;

    public Integer getId() {
        return idFarm;
    }

    public void setId(Integer id) {
        this.idFarm = idFarm;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getExtension() {
        return extension;
    }

    public void setExtension(Integer extension) {
        this.extension = extension;
    }

    public Farm getFarm() {
        return farm;
    }

    public void setFarm(Farm farm) {
        this.farm = farm;
    }

    public List<Reservation> getMessages() {
        return messages;
    }

    public void setMessages(List<Reservation> messages) {
        this.messages = messages;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
