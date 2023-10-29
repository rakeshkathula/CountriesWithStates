package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.NewTable;


public interface NewTableRepository extends JpaRepository<NewTable, Integer> {

}


