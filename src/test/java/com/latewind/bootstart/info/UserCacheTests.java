package com.latewind.bootstart.info;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


@AutoConfigureMockMvc
@SpringBootTest
class UserCacheTests {
	
	@Autowired
	private MockMvc mvc;
	@Test
	void contextLoads() {
	}

	
	@Test
	public void getALlCache() throws Exception{
		MvcResult result = mvc.perform(MockMvcRequestBuilders.get("/user/getAllUseCache").accept(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk()).andReturn();
		result.getModelAndView();
	}
	
	@Test
	public void getOneUseCache() throws Exception{
		MvcResult result = mvc.perform(MockMvcRequestBuilders.get("/user/getOneUseCache").queryParam("id", "2").accept(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk()).andReturn();
		result.getModelAndView();
	}
	

}
