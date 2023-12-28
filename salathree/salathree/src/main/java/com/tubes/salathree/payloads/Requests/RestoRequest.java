package com.tubes.salathree.payloads.Requests;

import com.tubes.salathree.models.Makanan;
import com.tubes.salathree.models.User;

public class RestoRequest {
    private User Resto;
    private int phone;
    private String alamatResto;
    private Makanan makanan;

    public RestoRequest() {
    }

    public RestoRequest(User Resto, int phone, String alamatResto, Makanan makanan) {
        this.Resto = Resto;
        this.phone = phone;
        this.alamatResto = alamatResto;
        this.makanan = makanan;
    }

    public User getResto() {
        return this.Resto;
    }

    public void setResto(User Resto) {
        this.Resto = Resto;
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

    public Makanan getMakanan() {
        return this.makanan;
    }

    public void setMakanan(Makanan makanan) {
        this.makanan = makanan;
    }

}
