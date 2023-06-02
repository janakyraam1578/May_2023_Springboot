package com.example.May2023.Repository;

import com.example.May2023.Model.Emp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpRepository extends JpaRepository<Emp, Integer> {
    //public List<Emp> findByName(String ename);

    public List<Emp> findByJob(String job); //select * from emp where job=?
}
