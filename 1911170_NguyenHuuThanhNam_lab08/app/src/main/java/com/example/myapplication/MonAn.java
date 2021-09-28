package com.example.myapplication;

public class MonAn {
    private String temon;
    private String mota;
    private String gia;
    private int hinh;

    public MonAn(String temon, String mota, String gia, int hinh) {
        this.temon = temon;
        this.mota = mota;
        this.gia = gia;
        this.hinh = hinh;
    }

    public String getTemon() {
        return temon;
    }

    public void setTemon(String temon) {
        this.temon = temon;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getGia(){return  gia;}
    public void setGia(String gia){this.gia =gia;}

    public int getHinh() {
        return hinh;
    }

    public void setHinh(int hinh) {
        this.hinh = hinh;
    }
}
