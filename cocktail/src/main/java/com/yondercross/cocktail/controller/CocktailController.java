package com.yondercross.cocktail.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


/**
 * The Class CocktailController contains the methods to get the api.
 */
@Configuration
@RestController
@RequestMapping("/drinks")
@CrossOrigin(origins = "*") 
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
	 * Gets all the drinks.
	 *
	 * @return the drinks
	 */
	@GetMapping
	public String getDrinks() {
		String url = "Https://www.thecocktaildb.com/api/json/v1/1/search.php?s";
		return restTemplate().getForObject(url, String.class);	
	}
	
	/**
	 * Gets the drinks by name.
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
