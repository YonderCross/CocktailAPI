package com.yondercross.cocktail.controller;

import org.springframework.context.annotation.Bean;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.yondercross.cocktail.model.CocktailModel;


/**
 * The Class CocktailController.
 */
@RestController
@RequestMapping("/drinks")
public class CocktailController {

    /**
     * Rest template.
     *
     * @return the rest template
     */
    @Bean
    RestTemplate restTemplate() {
	    return new RestTemplate();
	}    
	
	/**
	 * Gets the drinks.
	 *
	 * @return the drinks
	 */
	@GetMapping
	public String getDrinks() {
		String url = "Https://www.thecocktaildb.com/api/json/v1/1/search.php?s";
		return restTemplate().getForObject(url, String.class);	
	}
	
	/**
	 * Gets the by drink.
	 *
	 * @param path the path
	 * @return the by drink
	 */
	@GetMapping(path= "/{drink}")
	public String getByDrink(@PathVariable("drink") String path) {
		String url = "Https://www.thecocktaildb.com/api/json/v1/1/search.php?s=";
		return restTemplate().getForObject(url+path, String.class);
		
	}
}
