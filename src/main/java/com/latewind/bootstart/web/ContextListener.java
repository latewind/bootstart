package com.latewind.bootstart.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;

@WebListener
public class ContextListener implements ServletContextListener, ServletContextAttributeListener {

	public static final String INITIAL_CONTENT = "Content created in servlet Context";
	
	private Logger logger = LoggerFactory.getLogger(ContextListener.class);
	/**
	 * ServletContext创建
	 */
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		logger.error("===> context initialized");
		ServletContext servletContext = sce.getServletContext();
		servletContext.setAttribute("content", INITIAL_CONTENT);
	}

	/**
	 * ServletContext销毁
	 */
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		logger.error("===> context destroyed");
	}

	/**
	 * context属性新增
	 */
	@Override
	public void attributeAdded(ServletContextAttributeEvent scae) {
		logger.debug("===> context attribute added");
	}

	/**
	 * context属性移除
	 */
	@Override
	public void attributeRemoved(ServletContextAttributeEvent scae) {
		logger.debug("===> context attribute removed");
	}

	/**
	 * context属性替换
	 */
	@Override
	public void attributeReplaced(ServletContextAttributeEvent scae) {
		logger.debug("===> context attribute replaced");
	}
}