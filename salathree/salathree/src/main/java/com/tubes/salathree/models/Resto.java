package com.tubes.salathree.models;

// import java.time.LocalDateTime;
import java.util.List;
// import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
// import org.hibernate.annotations.CreationTimestamp;
// import org.hibernate.annotations.UpdateTimestamp;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "resto")
public class Resto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "resto_id")
    private User Resto;

    @Column(name = "name_resto", length = 30)
    private String name_resto;

    @Column(name = "phone", length = 12)
    private int phone;

    @Column(name = "alamatResto", length = 12)
    private String alamatResto;

    @OneToMany(mappedBy = "makanan_id", cascade = CascadeType.ALL)
    private List<Makanan> makanan_id;

    public Resto() {
    }

    public Resto(int id, User Resto, String name_resto, int phone, String alamatResto, List<Makanan> makanan_id) {
        this.id = id;
        this.Resto = Resto;
        this.name_resto = name_resto;
        this.phone = phone;
        this.alamatResto = alamatResto;
        this.makanan_id = makanan_id;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getResto() {
        return this.Resto;
    }

    public void setResto(User Resto) {
        this.Resto = Resto;
    }

    public String getName_resto() {
        return this.name_resto;
    }

    public void setName_resto(String name_resto) {
        this.name_resto = name_resto;
    }

    public int getPhone() {
        return this.phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getAlamatResto() {
        return this.alamatResto;
    }

    public void setAlamatResto(String alamatResto) {
        this.alamatResto = alamatResto;
    }

    public List<Makanan> getMakanan_id() {
        return this.makanan_id;
    }

    public void setMakanan_id(List<Makanan> makanan_id) {
        this.makanan_id = makanan_id;
    }

}
