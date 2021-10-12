package com.latewind.bootstart.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = Exception.class)
	public ModelAndView defaultProcess(HttpServletRequest req, Exception e) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("e", e);
		mv.setViewName("forward:/error/500");
		return mv;
	}

}
