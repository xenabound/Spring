package com.belajar.spring.entity;

import java.io.Serializable;
import java.util.List;


public class MataKuliah implements Serializable {

    private int id;
    private String nama_matakuliah;

    private List<Report> reports;

    public MataKuliah() {
    }

    public MataKuliah(int id) {
        this.id = id;
    }

    public MataKuliah(String nama_matakuliah) {
        this.nama_matakuliah = nama_matakuliah;

    }

    public MataKuliah(int id, String nama_matakuliah) {
        this.id = id;
        this.nama_matakuliah = nama_matakuliah;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama_matakuliah() {
        return nama_matakuliah;
    }

    public void setNama_matakuliah(String nama_matakuliah) {
        this.nama_matakuliah = nama_matakuliah;
    }


    @Override
    public String toString() {
        return "Matakuliah{" +
                "id=" + id +
                ", nama_matakuliah='" + nama_matakuliah + '\'' +

                '}';
    }
}
