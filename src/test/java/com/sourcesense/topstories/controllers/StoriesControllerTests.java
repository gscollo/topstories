package com.sourcesense.topstories.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.sourcesense.topstories.boot.Application;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
@AutoConfigureMockMvc
public class StoriesControllerTests {
	
	@Autowired
    private MockMvc mockMvc;
	
	@Test
	public void testTopStories() throws Exception {
		this.mockMvc.perform(get("/news")).andDo(print()).andExpect(status().isOk());
	}
	
	@Test
	public void testNewYorkTimesTopStories() throws Exception {
		this.mockMvc.perform(get("/news/nytimes")).andDo(print()).andExpect(status().isOk());
	}
	
	@Test
	public void testHackerNews() throws Exception {
		this.mockMvc.perform(get("/news/hacker-news")).andDo(print()).andExpect(status().isOk());
	}
	
}
