package com.yondercross.cocktail.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/drinks")
public class CocktailController {
	
	@GetMapping
	public String getDrinks() {
		
		RestTemplate restTemplate = new RestTemplate();
		String url = "Https://www.thecocktaildb.com/api/json/v1/1/search.php?s";
		return restTemplate.getForObject(url, String.class);
	}
	
	@GetMapping(path= "/{drink}")
	public String getByDrink(@PathVariable("drink") String path) {
		RestTemplate restTemplate = new RestTemplate();
		String url = "Https://www.thecocktaildb.com/api/json/v1/1/search.php?s=";
		return restTemplate.getForObject(url+path, String.class);
		
	}
}
