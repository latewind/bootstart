package com.latewind.bootstart.config;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.Serializable;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import com.latewind.bootstart.info.bean.UserEntity;

@SpringBootTest
public class SpringBootRedisApplicationTests {

	@Autowired
	private RedisTemplate<String, String> strRedisTemplate;
	@Autowired
	private RedisTemplate<String, Serializable> serializableRedisTemplate;

	@Test
	public void testString() {
		strRedisTemplate.opsForValue().set("strKey", "strValue");
		assertEquals("strValue", strRedisTemplate.opsForValue().get("strKey"));
	}

	@Test
	public void testSerializable() {
		UserEntity user = new UserEntity();
		user.setId(1L);
		user.setUserName("userName");
		user.setUserSex("男");
		serializableRedisTemplate.opsForValue().set("user", user);
		UserEntity user2 = (UserEntity) serializableRedisTemplate.opsForValue().get("user");
		assertEquals("userName", user2.getUserName());
	}
}