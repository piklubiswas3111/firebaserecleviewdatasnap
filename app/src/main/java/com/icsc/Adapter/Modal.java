package com.icsc.Adapter;

public class Modal {
    String tenpdf;
    String tendownload;

    public Modal() {
    }

    public Modal(String tenpdf, String tendownload) {
        this.tenpdf = tenpdf;
        this.tendownload = tendownload;
    }

    public String getTenpdf() {
        return tenpdf;
    }

    public void setTenpdf(String tenpdf) {
        this.tenpdf = tenpdf;
    }

    public String getTendownload() {
        return tendownload;
    }

    public void setTendownload(String tendownload) {
        this.tendownload = tendownload;
    }
}
