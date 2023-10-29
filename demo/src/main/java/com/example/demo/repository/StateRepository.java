package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.State;

public interface StateRepository extends JpaRepository<State, Integer> {
	
	List<State> findByCountryId(Integer id);

}
