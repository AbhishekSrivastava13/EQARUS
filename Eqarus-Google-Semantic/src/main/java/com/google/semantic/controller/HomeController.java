package com.google.semantic.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.semantic.bean.RedditTokenBean;
import com.google.semantic.bean.TwitterRequestBean;
import com.google.semantic.response.SentimentResponseBean;
import com.google.semantic.response.SentimentWrapperResponse;
import com.google.semantic.service.LanguageAnalyzeService;

@RestController
public class HomeController {

	@Autowired
	private LanguageAnalyzeService languageAnalyzeService;

	@PostMapping("/home")
	public SentimentWrapperResponse getLanguageAnalysis(@RequestBody TwitterRequestBean twitterRequestBean)
			throws IOException {
		final Logger logger = LoggerFactory.getLogger(this.getClass());		
		//logger.info("Inside the method SentimentWrapperResponse getLanguageAnalysis()");
		return languageAnalyzeService.languageAnalysis(twitterRequestBean);
	}

}
