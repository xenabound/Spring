package com.belajar.spring.dao;

import com.belajar.spring.entity.MataKuliah;

import java.util.List;

/**
 * Created by sukenda on 29/07/18.
 * Project belajar-spring
 */
public interface BaseDAO<T> {

    T save(T param);

    T update(T param);

    MataKuliah delete(T param);

    List<T> find();

    T findById(int id);

}
