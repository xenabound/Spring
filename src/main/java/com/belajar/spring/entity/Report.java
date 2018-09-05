package com.belajar.spring.entity;

import java.io.Serializable;
import java.util.List;


public class Report implements Serializable {

    private int id;
    private int id_student;
    private String id_matakuliah;


    public Report() {
    }

    public Report(int id) {
        this.id = id;
    }

    public Report(int id_student, String id_matakuliah) {
        this.id_student = id_student;
        this.id_matakuliah = id_matakuliah;
    }

    public Report(int id, int id_student, String id_matakuliah) {
        this.id = id;
        this.id_student = id_student;
        this.id_matakuliah = id_matakuliah;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_student() {
        return id_student;
    }

    public void setId_student(int id_student) {
        this.id_student = id_student;
    }

    public String getId_matakuliah() {
        return id_matakuliah;
    }

    public void setId_matakuliah(String id_matakuliah) {
        this.id_matakuliah = id_matakuliah;
    }

    @Override
    public String toString() {
        return "Report{" +
                "id=" + id +
                ", id_student='" + id_student + '\'' +
                ", id_matakuliah='" + id_matakuliah + '\'' +
                '}';
    }
}
