package com.belajar.spring.dao;

import com.belajar.spring.entity.MataKuliah;
import com.belajar.spring.entity.Report;

import java.util.List;


public interface MataKuliahDAO extends BaseDAO<MataKuliah> {

    List<Report> findByIdMatakuliah(int id);

    List<Report> findMataKuliahByStudent(int id);

    List<Report> findMataKuliahByid(int id);
}
