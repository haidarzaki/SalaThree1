package com.tubes.salathree.payloads.Requests;

import com.tubes.salathree.models.*;;

public class OrdersRequest {
    int pelanggan_id;
    Label label;
    Sorted_Menu sorted_Menu;

    public OrdersRequest() {
    }

    public OrdersRequest(int pelanggan_id, Label label, Sorted_Menu sorted_Menu) {
        this.pelanggan_id = pelanggan_id;
        this.label = label;
        this.sorted_Menu = sorted_Menu;
    }

    public int getPelanggan_id() {
        return this.pelanggan_id;
    }

    public void setPelanggan_id(int pelanggan_id) {
        this.pelanggan_id = pelanggan_id;
    }

    public Label getLabel() {
        return this.label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public Sorted_Menu getSorted_Menu() {
        return this.sorted_Menu;
    }

    public void setSorted_Menu(Sorted_Menu sorted_Menu) {
        this.sorted_Menu = sorted_Menu;
    }

}
