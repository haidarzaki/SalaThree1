package com.tubes.salathree.models;

//import java.time.LocalDateTime;

//import org.hibernate.annotations.CreationTimestamp;
//import org.hibernate.annotations.UpdateTimestamp;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pelanggan")
public class Pelanggan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "pelanggan_id")
    private User Pelanggan; // Rename "customer" to "CustomerAddress"

    @Column(length = 64)
    private int budget;
    @Column(length = 12)
    private int phone;

    public Pelanggan() {
    }

    public Pelanggan(Integer id, User Pelanggan, int budget, int phone) {
        this.id = id;
        this.Pelanggan = Pelanggan;
        this.budget = budget;
        this.phone = phone;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getPelanggan() {
        return this.Pelanggan;
    }

    public void setPelanggan(User Pelanggan) {
        this.Pelanggan = Pelanggan;
    }

    public int getBudget() {
        return this.budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public int getPhone() {
        return this.phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

}