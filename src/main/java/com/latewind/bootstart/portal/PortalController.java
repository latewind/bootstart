package com.latewind.bootstart.portal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PortalController {

	@RequestMapping("/hello")
	public String hello() {

		return "Hello World";
	}
	
	@RequestMapping("/helloBoot")
	public String helloBoot() {

		return "HELLO BOOT";
	}
	
	/**
	 * 产生错误
	 * @return
	 */
	@RequestMapping("/occorError")
	public String occorError() {
		int a = 1;
		int b = 0;
		a = a/b;
		return "";
	}
}
