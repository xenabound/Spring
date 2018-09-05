package com.belajar.spring.service;

import com.belajar.spring.dao.MataKuliahDAO;
import com.belajar.spring.entity.MataKuliah;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MataKuliahService {

    @Autowired
    private MataKuliahDAO mataKuliahDAO;

    public List<MataKuliah> find(){
        return mataKuliahDAO.find();
    }
}
