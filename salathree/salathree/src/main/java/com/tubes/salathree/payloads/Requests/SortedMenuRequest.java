package com.tubes.salathree.payloads.Requests;

import java.util.List;
import com.tubes.salathree.models.Makanan;
import com.tubes.salathree.models.Resto;

public class SortedMenuRequest {
    private List<Makanan> makanan;
    private Resto resto;

    public SortedMenuRequest() {
    }

    public SortedMenuRequest(List<Makanan> makanan, Resto resto) {
        this.makanan = makanan;
        this.resto = resto;
    }

    public List<Makanan> getMakanan() {
        return this.makanan;
    }

    public void setMakanan(List<Makanan> makanan) {
        this.makanan = makanan;
    }

    public Resto getResto() {
        return this.resto;
    }

    public void setResto(Resto resto) {
        this.resto = resto;
    }

}
