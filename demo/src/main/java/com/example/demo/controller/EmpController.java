package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.CountriesWithStates;
import com.example.demo.model.Country;
import com.example.demo.model.NewTable;
import com.example.demo.model.State;
import com.example.demo.repository.CountryRepository;
import com.example.demo.repository.NewTableRepository;
import com.example.demo.repository.StateRepository;
import com.example.demo.service.CountryService;

@RestController
public class EmpController {

	@Autowired
	private NewTableRepository newTableRepository;

	@Autowired
	private CountryRepository countryRepository;

	@Autowired
	private StateRepository stateRepository;

	@Autowired
	private CountryService countryService;

	@GetMapping("/getData")
	public List<NewTable> getData() {

		return newTableRepository.findAll();
	}

	@GetMapping("/getDataById/{id}")
	public NewTable getDataById(@PathVariable Integer id) throws Exception {

		return newTableRepository.findById(id).orElseThrow(() -> new Exception("Invalid id"));
	}

	@GetMapping("/getCountries")
	public List<Country> getCountries() {

		return countryRepository.findAll();
	}

	@GetMapping("/getCountriesById/{id}")
	public Country getCountriesId(@PathVariable Integer id) throws Exception {

		return countryRepository.findById(id).orElseThrow(() -> new Exception("Invalid id"));
	}

	@GetMapping("/getStates")
	public List<State> getStates() {
		return stateRepository.findAll();
	}

	@GetMapping("/getStatesById/{id}")
	public State getStatesById(@PathVariable Integer id) throws Exception {
		return stateRepository.findById(id).orElseThrow(() -> new Exception("Invalid id"));
	}

	@GetMapping("/getCountriesWithStates")
	public List<CountriesWithStates> getCountriesWithStates() {
		return countryService.getCountriesWithStates();

	}

}
