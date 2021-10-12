package com.latewind.bootstart.exception;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@AutoConfigureMockMvc
@SpringBootTest
class GlobalExceptionHandlerTest {

	@Autowired
	private MockMvc mvc;

	@Test
	void testDefaultProcess() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/occorError").accept(MediaType.APPLICATION_JSON))
				.andExpect(model().attributeExists("e")).andExpect(view().name("forward:/error/500"));
	}

}
