package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.CountriesWithStates;
import com.example.demo.model.Country;
import com.example.demo.repository.CountryRepository;
import com.example.demo.repository.StateRepository;

@Service
public class CountryService {

	@Autowired
	private CountryRepository countryRepository;

	@Autowired
	private StateRepository stateRepository;

	public List<CountriesWithStates> getCountriesWithStates() {

		List<CountriesWithStates> cwsList = new ArrayList<>();

		List<Country> countryList = countryRepository.findAll();

		for (Country cws : countryList) {

			CountriesWithStates countriesWithStates = new CountriesWithStates();

			countriesWithStates.setCapitalCity(cws.getCapitalCity());
			countriesWithStates.setCountryId(cws.getCountryId());
			countriesWithStates.setCountryName(cws.getCountryName());
			countriesWithStates.setCurrency(cws.getCurrency());
			countriesWithStates.setPopulation(cws.getPopulation());
			countriesWithStates.setStates(stateRepository.findByCountryId(cws.getCountryId()));
			cwsList.add(countriesWithStates);
		}

		return cwsList;

	}

}
