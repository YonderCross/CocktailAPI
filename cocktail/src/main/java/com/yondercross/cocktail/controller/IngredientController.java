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
 * The Class CocktailController.
 */
@Configuration
@RestController
@RequestMapping("/ingredients")
@CrossOrigin(origins = "*") 
public class IngredientController {

    /**
     * Rest template.
     *
     * @return the rest template
     */
    @Bean
    RestTemplate restTemplat() {
	    return new RestTemplate();
	}    
	/**
	 * Gets the drinks by ingredient.
	 *
	 * @return the drinks
	 */
	@GetMapping(path="{ingredient}")
	public String getByIngredient(@PathVariable("ingredient") String path) {
		String url = "https://www.thecocktaildb.com/api/json/v1/1/filter.php?i=";
		return restTemplat().getForObject(url+ path, String.class);
		
	}
}
