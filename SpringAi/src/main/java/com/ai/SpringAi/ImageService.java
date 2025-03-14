package com.ai.SpringAi;

import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.ai.openai.OpenAiImageModel;
import org.springframework.ai.openai.OpenAiImageOptions;
import org.springframework.stereotype.Service;


@Service
public class ImageService {

	
	private final OpenAiImageModel openAiImageModel;
	
	public ImageService (OpenAiImageModel openAiImageModel) {
		this.openAiImageModel=openAiImageModel;
	}
	
	public ImageResponse generateImage(String prompt) {
//		ImageResponse imageResponse = openAiImageModel.call(
//		  new ImagePrompt(prompt));
		  
		ImageResponse imageResponse = openAiImageModel.call(
		        new ImagePrompt("A light cream colored mini golden doodle",
		        OpenAiImageOptions.builder()
		                .quality("hd")
		                .N(4)
		                .height(1024)
		                .width(1024).build())

		);
				return imageResponse;
	}

}
