package com.hoangan.cafe.model;

public class Loaisp {

    private int id;
    private String tenLoaisp;
    private String hinhanhloaisp;

    public Loaisp(int id, String đăng_xuất, int home) {
    }

    public Loaisp(int id, String tenLoaisp, String hinhanhloaisp) {
        this.id = id;
        this.tenLoaisp = tenLoaisp;
        this.hinhanhloaisp = hinhanhloaisp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenLoaisp() {
        return tenLoaisp;
    }

    public void setTenLoaisp(String tenLoaisp) {
        this.tenLoaisp = tenLoaisp;
    }

    public String getHinhanhloaisp() {
        return hinhanhloaisp;
    }

    public void setHinhanhloaisp(String hinhanhloaisp) {
        this.hinhanhloaisp = hinhanhloaisp;
    }
}
