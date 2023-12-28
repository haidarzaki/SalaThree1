package com.tubes.salathree.models;

// import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
// import jakarta.persistence.OneToOne;
import jakarta.persistence.ManyToOne;
// import jakarta.persistence.OneToMany;
// import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer order_id;

    @ManyToOne
    @JoinColumn(name = "pelanggan_id")
    private Pelanggan pelanggan_id;

    @ManyToOne(targetEntity = Label.class)
    @JoinColumn(name = "label_id")
    private int label_id;

    @ManyToOne(targetEntity = Sorted_Menu.class)
    @JoinColumn(name = "sorted_menu_id")
    private int sorted_menu_id;

    public Orders() {
    }

    public Orders(Integer order_id, Pelanggan pelanggan_id, int label_id, int sorted_menu_id) {
        this.order_id = order_id;
        this.pelanggan_id = pelanggan_id;
        this.label_id = label_id;
        this.sorted_menu_id = sorted_menu_id;
    }

    public Integer getOrder_id() {
        return this.order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public Pelanggan getPelanggan_id() {
        return this.pelanggan_id;
    }

    public void setPelanggan_id(Pelanggan pelanggan_id) {
        this.pelanggan_id = pelanggan_id;
    }

    public int getLabel_id() {
        return this.label_id;
    }

    public void setLabel_id(int label_id) {
        this.label_id = label_id;
    }

    public int getSorted_menu_id() {
        return this.sorted_menu_id;
    }

    public void setSorted_menu_id(int sorted_menu_id) {
        this.sorted_menu_id = sorted_menu_id;
    }

}
