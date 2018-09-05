package com.belajar.spring.dao.impl;

import com.belajar.spring.dao.StudentDAO;
import com.belajar.spring.entity.MataKuliah;
import com.belajar.spring.entity.Student;
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
public class StudentDAOImpl implements StudentDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Student save(Student param) {
        String sql = "INSERT INTO table_students (name, address) VALUES (?, ?)";
        final KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, param.getName());
            ps.setString(2, param.getAddress());
            return ps;
        }, keyHolder);

        param.setId(keyHolder.getKey().intValue());
        return param;
    }

    @Override
    public Student update(Student param) {
        String sql = "update table_student set name = ?, address = ? where id = ?)";
        final KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, param.getName());
            ps.setString(2, param.getAddress());
            return ps;
        }, keyHolder);

        param.setId(keyHolder.getKey().intValue());
        return param;
    }

    @Override
    public MataKuliah delete(Student param) {
        String sql = "delete from table_student where id = ?";
        final KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, param.getName());

            return ps;
        }, keyHolder);

        param.setId(keyHolder.getKey().intValue());
        return param;
    }

    @Override
    public List<Student> find() {
        String sql = "SELECT * FROM table_students";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class));
    }

    @Override
    public Student findById(int id) {
        String sql = "select * " +
                "from table_student_matakuliah id on table_student.id = table_student_matakuliah.id " +
                "where table_student_matakuliah = "+id;
        return null;
    }

    @Override
    public List<MataKuliah> findMataKuliahByStudent(int id) {
        String sql = "select * " +
                "from table_matakuliah " +
                "inner join table_student_matakuliah student on mata.id = table_student_matakuliah.id_mata_kuliah " +
                "where student.id_student = "+id;
        return null;
    }
}
