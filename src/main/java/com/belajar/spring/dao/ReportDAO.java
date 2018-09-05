package com.belajar.spring.dao;

import com.belajar.spring.entity.MataKuliah;
import com.belajar.spring.entity.Student;
import com.belajar.spring.entity.Report;

import java.util.List;


public interface ReportDAO extends BaseDAO<Report> {

    @Override
    Report findById(int id);
}
