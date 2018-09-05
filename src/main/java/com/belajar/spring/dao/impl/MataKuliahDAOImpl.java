package com.belajar.spring.dao.impl;

import com.belajar.spring.dao.MataKuliahDAO;
import com.belajar.spring.entity.MataKuliah;
import com.belajar.spring.entity.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;



@Repository
public class MataKuliahDAOImpl implements MataKuliahDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public MataKuliah save(MataKuliah param) {
        String sql = "INSERT INTO table_matakuliah (namamatkul) VALUES (?)";
        final KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, param.getNama_matakuliah());

            return ps;
        }, keyHolder);

        param.setId(keyHolder.getKey().intValue());
        return param;
    }

    @Override
    public MataKuliah update(MataKuliah param) {
        String sql = "update table_matakuliah set namamatkul = ?where id = ?)";
        final KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, param.getNama_matakuliah());

            return ps;
        }, keyHolder);

        param.setId(keyHolder.getKey().intValue());
        return param;
    }

    @Override
    public MataKuliah delete(MataKuliah param) {
        String sql = "delete from table_matakuliah where id = ?";
        final KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, param.getNama_matakuliah());

            return ps;
        }, keyHolder);

        param.setId(keyHolder.getKey().intValue());
        return param;
    }

    @Override
    public List<MataKuliah> find() {
        String sql = "SELECT * FROM table_matakuliah";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(MataKuliah.class));
    }

    @Override
    public MataKuliah findById(int id) {
        return null;
    }

    @Override
    public List<Report> findByIdMatakuliah(int id) {
        String sql = "select * " +
                "from table_student_matakuliah id on table_matakuliah.id = table_student_matakuliah.id_matakuliah " +
                "where table_matakuliah = "+id;
        return null;
    }

    @Override
    public List<Report> findMataKuliahByStudent(int id) {
        return null;
    }

    @Override
    public List<Report> findMataKuliahByid(int id) {
        String sql = "select * " +
                "from table_matakuliah " +
                "inner join table_student_matakuliah student on table_student.id = table_student_matakuliah.id_mata_kuliah " +
                "where table_student.id = "+id;
        return null;
    }
}
