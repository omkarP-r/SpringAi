package com.ai.SpringAi;

import java.io.IOException;
import java.util.List;

import org.springframework.ai.image.ImageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class GenAiController {

	@Autowired
	ChatService chatService;
	@Autowired
	ImageService imageService;
	@Autowired
	RecipeService recipeService;
	
	@GetMapping("ask-ai")
	public String getResponse( @RequestParam String prompt) {
		return chatService.getResponse(prompt);
	}
	
	
	
	@GetMapping("ask-ai-options")
	public String getResponseOptions( @RequestParam String prompt) {
		return chatService.getResponseOptions(prompt);
	}
	
	
	@GetMapping("generate-image")
	public void generateImage(HttpServletResponse response, @RequestParam String prompt) throws IOException {
		ImageResponse imageResponse = imageService.generateImage(prompt);
		String ImageUrl = imageResponse.getResult().getOutput().getUrl();
		response.sendRedirect(ImageUrl);  
	}
	
	
	@GetMapping("recipe-creator")
	public String generateRecipe( @RequestParam String ingredients,
			@RequestParam(defaultValue = "any") String cuisine,
			@RequestParam String dietaryRestrictions) {
		return recipeService.createRecipe(ingredients, cuisine, dietaryRestrictions);
	}
}
