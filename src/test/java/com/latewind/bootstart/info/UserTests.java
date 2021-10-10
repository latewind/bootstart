package com.latewind.bootstart.info;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.latewind.bootstart.info.bean.UserEntity;

@AutoConfigureMockMvc
@SpringBootTest
class UserTests {
	
	@Autowired
	private MockMvc mvc;
	@Test
	void contextLoads() {
	}

	
	@Test
	public void getALl() throws Exception{
		mvc.perform(MockMvcRequestBuilders.get("/user/getAll").accept(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk());
	}
	
	@Test
	public void insert() throws Exception{
		mvc.perform(MockMvcRequestBuilders.post("/user/insertUser2", new UserEntity()).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	
}
