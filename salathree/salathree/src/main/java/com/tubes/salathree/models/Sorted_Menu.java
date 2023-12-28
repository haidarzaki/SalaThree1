package com.tubes.salathree.models;

// import java.time.LocalDateTime;
import java.util.List;
// import org.hibernate.annotations.CreationTimestamp;
// import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// import javax for Column
import jakarta.persistence.CascadeType;
// import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
// import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "sorted_menu")
public class Sorted_Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sorted_menu_id;

    @OneToMany(mappedBy = "makanan_id", cascade = CascadeType.ALL)
    private List<Makanan> makanan;

    @ManyToOne
    @JoinColumn(name = "resto_id")
    private Resto resto_id;

    public Sorted_Menu() {
    }

    public Sorted_Menu(int sorted_menu_id, List<Makanan> makanan, Resto resto_id) {
        this.sorted_menu_id = sorted_menu_id;
        this.makanan = makanan;
        this.resto_id = resto_id;
    }

    public int getSorted_menu_id() {
        return this.sorted_menu_id;
    }

    public void setSorted_menu_id(int sorted_menu_id) {
        this.sorted_menu_id = sorted_menu_id;
    }

    @JsonIgnoreProperties({ "makanan" })
    public List<Makanan> getMakanan() {
        return this.makanan;
    }

    public void setMakanan(List<Makanan> makanan) {
        this.makanan = makanan;
    }

    public Resto getResto_id() {
        return this.resto_id;
    }

    public void setResto_id(Resto resto_id) {
        this.resto_id = resto_id;
    }

}
