package com.tubes.salathree.payloads.Requests;

public class LabelRequest {
    private String detail;

    public LabelRequest() {
    }

    public LabelRequest(String detail) {
        this.detail = detail;
    }

    public String getDetail() {
        return this.detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

}
