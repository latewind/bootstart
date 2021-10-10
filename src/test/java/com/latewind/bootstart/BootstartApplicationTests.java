package com.latewind.bootstart;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.latewind.bootstart.portal.PortalController;

@SpringBootTest
class BootstartApplicationTests {

	private MockMvc mvc;

	@Test
	void contextLoads() {
	}

	@BeforeEach
	public void setUp() throws Exception {
		mvc = MockMvcBuilders.standaloneSetup(new PortalController()).build();
	}

	@Test
	public void hello() throws Exception {
		mvc = MockMvcBuilders.standaloneSetup(new PortalController()).build();
		mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(content().string(equalTo("Hello World")));
	}

}
