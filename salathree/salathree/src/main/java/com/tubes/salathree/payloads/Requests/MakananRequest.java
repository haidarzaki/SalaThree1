package com.tubes.salathree.payloads.Requests;

import com.tubes.salathree.models.Label;;

public class MakananRequest {
    private String name_makanan;
    private Label label;
    private int harga;

    public MakananRequest() {
    }

    public MakananRequest(String name_makanan, Label label, int harga) {
        this.name_makanan = name_makanan;
        this.label = label;
        this.harga = harga;
    }

    public String getName_makanan() {
        return this.name_makanan;
    }

    public void setName_makanan(String name_makanan) {
        this.name_makanan = name_makanan;
    }

    public Label getLabel() {
        return this.label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public int getHarga() {
        return this.harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

}
