package com.tubes.salathree.payloads.Requests;

import com.tubes.salathree.models.User;

public class PelangganRequest {
    private User Pelanggan;
    private int budget;
    private int phone;

    public PelangganRequest() {
    }

    public PelangganRequest(User Pelanggan, int budget, int phone) {
        this.Pelanggan = Pelanggan;
        this.budget = budget;
        this.phone = phone;
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
